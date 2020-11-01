package org.evomaster.e2etests.spring.examples.market;


import static org.junit.jupiter.api.Assertions.assertTrue;

import com.foo.rest.examples.spring.market.MarketController;
import org.evomaster.core.problem.rest.HttpVerb;
import org.evomaster.core.problem.rest.RestIndividual;
import org.evomaster.core.search.Solution;
import org.evomaster.e2etests.spring.examples.SpringTestBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Created by agusaldasoro on 11-Oct-2020.
 */
public class MarketTest extends SpringTestBase {


	@BeforeAll
	public static void initClass() throws Exception {

		SpringTestBase.initClass(new MarketController());
	}

	@Test
	public void testRunEM() throws Throwable {
		try {
			runTestHandlingFlakyAndCompilation(
					"MarketEM",
					"org.bar.MarketEM",
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
