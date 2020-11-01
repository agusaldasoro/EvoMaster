package com.foo.rest.examples.spring.db;

import com.foo.rest.examples.spring.SpringController;
import kotlin.random.Random;
import org.evomaster.client.java.controller.api.dto.SutInfoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;

public class SpringWithPostgresDbController extends SpringController {

	protected Connection connection;

	protected SpringWithPostgresDbController(Class<?> applicationClass) {
		super(applicationClass);
	}

	@Override
	public String startSut() {
		ctx = SpringApplication.run(applicationClass, "--server.port=0",
				// TODO: support for different dbs hosts and ports
				"--spring.datasource.url=jdbc:p6spy:postgresql://localhost:5432/plain_select_application_test",
				"--spring.datasource.type=com.zaxxer.hikari.HikariDataSource",
				"--spring.datasource.hikari.maximum-pool-size=24",
				"--spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false",
				"--spring.jpa.properties.hibernate.current_session_context_class=org.springframework.orm.hibernate5.SpringSessionContext",
				"--spring.liquibase.change-log=classpath:migrations.xml",
				"--spring.datasource.driver-class-name=com.p6spy.engine.spy.P6SpyDriver",
				"--spring.datasource.username=username",
				"--spring.datasource.password=password",
				"--spring.jpa.properties.hibernate.show_sql=true");


		JdbcTemplate jdbc = ctx.getBean(JdbcTemplate.class);

		try {
			connection = Objects.requireNonNull(jdbc.getDataSource()).getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Application started running OK.");

		return "http://localhost:" + getSutPort();
	}

	@Override
	public void resetStateOfSUT() {
		try {
			connection.createStatement()
					// TODO: Do a generic delete
					.executeUpdate("DELETE FROM welcomes;\n");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void stopSut() {
		try {
			connection.createStatement()
					// TODO: Do a generic delete
					.executeUpdate("DELETE FROM welcomes;\n");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		ctx.stop();
	}

	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public String getDatabaseDriverName() {

		return "org.postgresql.Driver";
	}

	@Override
	public int getSutPort() {
		return (Integer) ((Map) Objects.requireNonNull(ctx.getEnvironment()
				.getPropertySources().get("server.ports")).getSource())
				.get("local.server.port");
	}

	/**
	 * Specify the format in which the test cases should be generated
	 */
	@Override
	public SutInfoDto.OutputFormat getPreferredOutputFormat() {
		return SutInfoDto.OutputFormat.JAVA_JUNIT_4;
	}

}
