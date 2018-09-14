package gradle.cucumber;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepDefinitions {
    
	WebDriver driver;


    @Given("I open {string}")
    public void i_open(String string) {
        if (string == null){
            driver = new ChromeDriver();
        }
        else if (string == "chrome") {
            driver = new ChromeDriver();
        }
        else if (string == "firefox") {
            driver = new FirefoxDriver();
        }
        else {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }


   @Given("I open wikipedia")
    public void i_open_wikipedia() {
       driver.get("https://en.wikipedia.org/wiki/Main_Page");
    }

    @When("I search {string}")
    public void i_search(String string) {
	    WebElement barreRecherche = driver.findElement(By.id("searchInput"));
        barreRecherche.sendKeys(string);
        barreRecherche.sendKeys(Keys.ENTER);
    }



    @Then("I should see {string}")
    public void i_should_see(String string) {
        WebElement title = driver.findElement(By.id("firstHeading"));
        String result = title.getText();
        Assert.assertEquals(result, string);
    }


    @After
    public void closeBrowser() {
	    driver.quit();
    }
    
}
