package utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriverException;

public class Hooks {
    BrowserDriver driver;

    @Before
    public void setUp() {
        try {
            if (driver == null) {
                driver = new BrowserDriver();
                driver.launchBrowser();
            }
        } catch (WebDriverException webDriverException) {
            System.out.println("Driver error " + webDriverException);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        driver.closeBrowser(scenario);
    }
}
