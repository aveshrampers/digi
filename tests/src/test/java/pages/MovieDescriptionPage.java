package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utility.BrowserDriver;

import java.util.List;

public class MovieDescriptionPage extends BrowserDriver {

    public MovieDescriptionPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindAll(@FindBy(how = How.CSS, using = "td a"))
    List<WebElement> title_name;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[contains(.,'Species')]/ul/li"))
    List<WebElement> species;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[contains(.,'Planets')]/ul/li"))
    List<WebElement> planets;

    @FindBy(how = How.XPATH, using = "//@class[contains(.,'layout_header')]")
    WebElement home_image;

    public void Verify_Homepage() {
        try {
            home_image.isDisplayed();
        } catch (Exception e) {
            System.out.println("The exception " + e);
        }
    }

    public void Navigate_To_Title_Description(String title) {
        try {
            for (WebElement webElement : title_name) {
                if ((webElement.getAttribute("textContent").equals(title))) {
                    webElement.click();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public void Assert_Species(String title) {
        try {
            for (WebElement webElement : species) {
                if (!webElement.getText().equals(title)) {
                    continue;
                }
                Assert.assertEquals(webElement.getText(), title);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public void Assert_Planet(String title) {
        try {
            for (WebElement webElement : planets) {
                if (!webElement.getText().equals(title)) {
                    continue;
                }
                Assert.assertNotEquals(webElement.getText(), title);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}