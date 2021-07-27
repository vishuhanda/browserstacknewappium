import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class logintest {

    @Test
    public void firstTest() throws MalformedURLException, InterruptedException {

        Drivermanager.initDriver();
//
//        loginpage demoPage = new loginpage();
//        demoPage.clickBtn();

        System.out.println("First test");
        Drivermanager.tearDownDriver();

    }

}
