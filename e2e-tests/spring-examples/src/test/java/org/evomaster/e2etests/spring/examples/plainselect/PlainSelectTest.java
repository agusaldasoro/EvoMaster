package org.evomaster.e2etests.spring.examples.plainselect;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.evomaster.core.problem.rest.HttpVerb;
import org.evomaster.core.problem.rest.RestIndividual;
import org.evomaster.core.search.Solution;
import org.evomaster.e2etests.spring.examples.SpringTestBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Created by agusaldasoro on 17-Feb-2020.
 */
public class PlainSelectTest extends SpringTestBase {

    @BeforeAll
    public static void initClass() throws Exception {

        SpringTestBase.initClass(new com.foo.rest.examples.spring.plainselect.PlainSelectController());
    }

    @Test
    public void testRunEM()  {

        try {
            runTestHandlingFlakyAndCompilation(
                    "PlainSelectEM",
                    "org.bar.PlainSelectEM",
                    100,
                    (args) -> {

                        Solution<RestIndividual> solution = initAndRun(args);

                        assertTrue(solution.getIndividuals().size() >= 1000);

                        assertHasAtLeastOne(solution, HttpVerb.POST, 201);
                    });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
