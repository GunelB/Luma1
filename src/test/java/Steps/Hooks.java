package Steps;

import Utils.CommonMethods;
import Utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

 public class Hooks extends CommonMethods {


   // @Before
   // public void initialize() {
      //  getDriver();
   // }
    @After
    public void teardown(Scenario scenario){

        byte[] pic;
        if (scenario.isFailed()) {
            pic = takeScreenShots("failed/" + scenario.getName());
        }else {
            pic = takeScreenShots("passed/" + scenario.getName());
        }
        scenario.attach(pic,"image/png", scenario.getName());


      // closeBrowser();
    }
}
