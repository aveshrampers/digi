package utility;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BrowserDriver {

    public static WebDriver driver;
    ChromeOptions options;

    public void launchBrowser() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        options = new ChromeOptions();
        options.addArguments(
                "--disable-dev-shm-usage",
                "--remote-debugging-pipe",
                "--headless",
                "--no-sandbox",
                "--allow-insecure-localhost"
        );
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        try {
            driver.get("http://localhost:3000/");
        } catch (Exception e) {
            System.out.println("Driver error " + e);
        }
    }

    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Failed screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
        driver.quit();
    }
}