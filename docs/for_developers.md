# NOTES FOR DEVELOPERS


These notes are meant for developers working on _EvoMaster_, and for people making a pull request.
There are several rules of thumb regarding how to write "good code",
but often rules are either too generic and not tailored for a given particular
piece of software (e.g., different kinds of architectures).

The rules of thumb described here in this document are not meant to be either exhaustive nor absolute.
Rigid rules are not substitute for common sense, as they are rather guidelines that can
be ignored in some special cases.
Furthermore, the guidelines need to be _realistic_ and easy to use: there would be no point
to ask for detailed comments on each single method/field and 100% coverage test suites...

These notes also include some explanations and motivations for some of the architectural choices
made in the development of _EvoMaster_.


### Kotlin vs. Java
The core process of _EvoMaster_ is built in _Kotlin_, as we strongly prefer it over _Java_.
However, the client libraries for JDK SUTs (e.g., not just _Java_, but also all other languages that do 
compile to JDK bytecode) are written in _Java_ instead of _Kotlin_.
The main reason is that, being libraries, we do not want to also have to ship the _Kotlin_ runtime 
libraries with them. 



### AVOID `System.out` AND `System.err`
_EvoMaster_ uses a logging framework.
For debugging  and logging errors in a class `Foo`, create a logger in the following way.

* for Java: `private static Logger log = LoggerFactory.getLogger(Foo.class);`
* for Kotlin: `companion object { private val log: Logger = LoggerFactory.getLogger(Foo::class.java)}`

It is important to keep the same name `log` to make things consistent among different classes.
If the logging should be part the actual output for the console user, then rather use: 

`LoggingUtil.getInfoLogger()`


### AVOID `String` CONCATENATION IN LOGGERS

Writing something like:

`log.debug("this is not "+ foo + " very " + bar +" efficient")`

is not efficient, as most of the time debug logs are deactivated, and concatenating strings is
expensive. Recall `String` is immutable, and each `+` does create a new `String` object.
The above logging can be rewritten into:

`log.debug("this is not {} very {} efficient", foo, bar)`

Note: not a big deal for _warn_/_error_, as those are/should be rare... but it can become
quite an overhead for _trace_/_debug_/_info_.




### DO NOT USE `System.exit`

Better to throw an exception, as the entry point of _EvoMaster_ does some logging when ends.
Furthermore, `System.exit` becomes problematic when unit testing _EvoMaster_.



### STATIC VARIABLES ARE YOUR ENEMY

Static variables should be either constant or representing transient data (e.g., cache information 
whose presence/missing has only effect on performance, not on functionality).
Having "classes with static state" is usually a poor OO design (an exception to this rule 
is `ExecutionTracer`).
If those are really needed, then you should rather use an _injectable_ singleton service (see next point). 
This is not just to be pedantic, but, really, non-constant static variables make unit testing 
far much harder and lead to code that is more difficult to understand and maintain. 


### `Guice` and `Governator`

To avoid issues with mutable static variables, we use a dependency injection framework.
In particular, we use `Guice`, extended with `Governator` to handle post-construct events.
All injectable services should be singletons, and declared under a package called `*.service` (this
is to make it easy to find out which services are available).

There is no auto-discovery of beans. This is done manually.
The reason is that, depending on configurations, we can have many different context initializations.
For example, the beans used for testing REST APIs would not be needed when testing GraphQL ones.  


### HOW TO WRITE UNIT TEST CASES

Unit tests should be put in the `src/test/java` and `src/test/kotlin` folders, 
following the same package structure as _EvoMaster_ code.
A unit test suite for SUT `org.evomaster.somepackage.Foo` __MUST__ be called `org.evomaster.somepackage.FooTest`.
This is important for several reasons:
- Need to know what class the test case is supposed to unit test by just looking at its name
- Should be easy to identify if a class has a test suite for it
- If in same package, then the test suite can access package/protected fields/methods
- Having `Test` as postfix (instead of a prefix) is useful for when searching for classes by name
- A `Test` postfix is a requirement for _Maven_ to execute the test suite during the build 


### HOW TO WRITE END-TO-END (E2E) TEST CASES

Besides unit tests, it is essential to have E2E ones as well.
Those should be added under the `e2e-tests` module. 
Being _non-deterministic_, we cannot guarantee that _EvoMaster_ can always find a valid solution (e.g., 
create test cases with certain properties).
Furthermore, we cannot run the E2E tests for long time (otherwise the CI builds will take forever).
The idea is to create artificial SUTs that should be _trivial_ to solve when some settings (which we want
to test) are on, and very difficult (if not straight-out infeasible) otherwise.

Note: current version of JUnit 5 is worse than JUnit 4 when dealing with E2E tests.
E.g., there is no handling of _flaky_ tests (in JUnit 4, this was handled by the _Surefire_/_Failsafe_ plugins).
This is the reason why such test executions should be wrapped inside a `handleFlaky` call.   


### AVOID TOO LONG METHODS

Too long methods (e.g., more than 100 lines) should be split, as difficult to understand.
For this task, in _IntelliJ_, you can right-click on a code snippet and choose 
"_Refactor -> Extract -> Function_" 




### WRITE COMMENTS

In the ideal world, each class/method/field would have nice, detailed, appropriate code comments.
But even in such a beautiful world, everything would go to hell at the first code change, as that might
require manually changing most of the code comments.

Cannot really quantify how much comments one should write, but at least it would be good to have:
* brief (1-2 sentences) description of what the class is useful for (just before the class declaration) 
* for fields that are data structures (e.g., collections and arrays) some comments would be useful, as long and detailed 
  variable names are not practical
* for `Map`s, should add a comment stating what is the _key_, and what is the _value_.   

When writing a comment for a class/method/field, use JavaDoc style:
/**
*/
In this way, your IDE can show the comments when you hover with the mouse over them.
  
  


### IF CANNOT AVOID EXTERNAL SIDE-EFFECTS, DO DOCUMENT IT!!!

If a call on a object has side-effects outside the class itself (e.g., writing to disk, add a system hook thread),
then this needs to be documented (see point on how to write comments),
unless it is obvious from the function/class name.  



### PRE AND POST CONDITIONS

* _Pre-conditions_ of `public` methods should throw exceptions explicitly 
  (e.g., `IllegalArgumentException` and `IllegalStateException`).
  Whenever possible, it is worth to write pre-conditions to `public` methods.
* _Pre-conditions_ of `private` methods and _post-conditions_ (both `public` and `private` methods) 
  should use the keyword `assert` in _Java_, and the function `assert()` in _Kotlin_.
  (An exception is when the validation of inputs of a public method is delegated/moved to 
  a `private` method: in this case you could add `throw`.)
  _Post-conditions_ are good, but often are difficult to write.
  Note: a _post-condition_ does not to be complete to be useful (i.e., find bugs). 
  For example, if we have _A && B_, but the writing
  of _B_ is too difficult (or time consuming), still having just _A_ as _post-condition_ can help  

Note: currently _Kotlin_ does not have lazily evaluated assertions. 
If you are writing a computational expensive check, rather user `Lazy.assert(predicate)`.  
  
  

### FIELDS/CONSTRUCTORS/METHODS ORDER IN A CLASS 

When writing a new class (or re-factoring a current one), fields should come first, 
followed by class constructors and then the other methods.



