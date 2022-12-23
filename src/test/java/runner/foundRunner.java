package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.FoundPage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature/login",glue="steps")
public class foundRunner {
    public static WebDriver driver;
    public static FoundPage foundPage;
    public static FoundPage foundNeg;
    public static FoundPage nav;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        foundPage = new FoundPage(driver);
        foundNeg = new FoundPage(driver);
        nav = new FoundPage(driver);
    }
    @AfterClass
    public static void teardown(){driver.quit();}
}
