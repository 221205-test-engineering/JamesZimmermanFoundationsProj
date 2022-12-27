package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.TestCase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.DefectPage;
import page.FoundPage;
import runner.foundRunner;

import java.time.Duration;

public class DefectStatusImpl {
    public WebDriver driver = foundRunner.driver;
    public DefectPage defectP = foundRunner.defectP;

    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page() {
        String tHome = defectP.testHome.getText();
        String TestH = "Tester Home";

        Assert.assertEquals(TestH,tHome);
    }

    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(defectP.TDefect));
        Boolean testDf = false;
        if(defectP.TDefect != null){
            testDf = true;
        }
        Assert.assertTrue(testDf);
    }

    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() {
        defectP.changeDf.click();
    }

    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(defectP.changeDf));
                Boolean tle = false;
                if(defectP.changeDf != null){
                    tle = true;
                }
                Assert.assertTrue(tle);
    }

}
