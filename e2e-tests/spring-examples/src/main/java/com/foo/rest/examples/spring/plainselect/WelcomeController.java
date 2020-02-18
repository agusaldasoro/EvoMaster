package com.foo.rest.examples.spring.plainselect;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class WelcomeController {

	private final WelcomeService service;

	public WelcomeController(WelcomeService welcomeService) {
		this.service = welcomeService;
	}

	@RequestMapping(value = "/v0/greeting", method = POST)
	@ResponseBody
	public ResponseEntity<Welcome> postGreeting(@RequestBody Welcome welcome) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(service.create(welcome));

	}

}
