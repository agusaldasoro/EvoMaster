package com.foo.rest.examples.spring.db.base;

import com.foo.rest.examples.spring.db.SpringWithH2DbController;

public class DbBaseController extends SpringWithH2DbController {

    public DbBaseController(){
        super(DbBaseApplication.class);
    }
}
