package com.foo.rest.examples.spring.plainselect;

import com.foo.rest.examples.spring.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by agusaldasoro on 17-Feb-2020.
 */
@EnableSwagger2
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PlainSelectApplication extends SwaggerConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(PlainSelectApplication.class, args);
	}

}
