package com.foo.rest.examples.spring.plainselect;

import com.foo.rest.examples.spring.db.SpringWithDbController2;
import org.evomaster.client.java.controller.problem.ProblemInfo;
import org.evomaster.client.java.controller.problem.RestProblem;

/**
 * Created by agusaldasoro on 17-Feb-2020.
 */
public class PlainSelectController extends SpringWithDbController2 {

	public PlainSelectController() {
		super(PlainSelectApplication.class);
	}

	@Override
	public ProblemInfo getProblemInfo() {
		return new RestProblem(
				"http://localhost:" + getSutPort() + "/plain-select.json",
				null);
	}

}
