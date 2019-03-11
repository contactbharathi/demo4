package grpid4;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import grpid4.driver.DriverManager;

public class Hooks extends DriverManager {

    DriverManager driverManager = new DriverManager();

    @Before

    public void setUp() {
        driverManager.runOnLocalHost();
        //driverManager.runOnRemoteHost();
        //driverManager.openBrowser();
        driverManager.navigateTo("http://argos.co.uk");
        driverManager.maxBrowser();
        driverManager.applyImpWait();
        driverManager.handleApplicationCookies();
    }

    @After


    public void tearDown() {
//        driverManager.closeBrowser();
    }
}

