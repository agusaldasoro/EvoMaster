package com.foo.rest.examples.spring.db.directint;

import com.foo.rest.examples.spring.db.SpringWithH2DbController;
import org.evomaster.client.java.controller.InstrumentedSutStarter;

public class DbDirectIntController extends SpringWithH2DbController {

    public DbDirectIntController() {
        super(DbDirectIntApplication.class);
    }


    public static void main(String[] args){
        DbDirectIntController controller = new DbDirectIntController();
        controller.setControllerPort(40100);
        InstrumentedSutStarter starter = new InstrumentedSutStarter(controller);
        starter.start();
    }
}
