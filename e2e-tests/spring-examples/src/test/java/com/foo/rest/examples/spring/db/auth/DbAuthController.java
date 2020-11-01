package com.foo.rest.examples.spring.db.auth;

import com.foo.rest.examples.spring.db.SpringWithH2DbController;
import org.evomaster.client.java.controller.AuthUtils;
import org.evomaster.client.java.controller.api.dto.AuthenticationDto;
import org.evomaster.client.java.controller.db.DbCleaner;
import org.evomaster.client.java.controller.db.SqlScriptRunner;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DbAuthController extends SpringWithH2DbController {

    private static final String userId = "foo";
    private static final String password = "123";

    public DbAuthController() {
        super(AuthApp.class);
    }


    @Override
    public List<AuthenticationDto> getInfoForAuthentication() {

       return Arrays.asList(AuthUtils.getForBasic("example", userId, password));
    }


    @Override
    public void resetStateOfSUT() {
        DbCleaner.clearDatabase_H2(connection);

        try {
            SqlScriptRunner.execInsert(connection,
                    "insert into Auth_User_Entity(user_id,password) values('"+userId+"','"+password+"');");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
