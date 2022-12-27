package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
public class reportDefectNegImpl {
    public WebDriver driver = foundRunner.driver;
    public DefectPage defectP = foundRunner.defectP;
    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() {
        String DefectRe = "Defect Reporter";
        String DefRe = defectP.DefectRep.getText();
        Assert.assertEquals(DefRe, DefectRe);
    }
    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() {
        defectP.dateIn.click();
    }

    @When("The employee types in description with")
    public void the_employee_types_in_description_with(String docSign) {
        defectP.description.sendKeys(docSign);
    }

    @When("The employee types in Steps with")
    public void the_employee_types_in_steps_with(String docStep) {
        defectP.stepps.sendKeys(docStep);
    }

    @When("The employee selects high priority")
    public void the_employee_selects_high_priority() {
        String pri = "High";
        String pts = defectP.prioritys.getText();

        Assert.assertEquals(pri,pts);
    }

    @When("The employee selects low severity")
    public void the_employee_selects_low_severity() {
       String lSev = "Low";
       String lSt = defectP.Severitys.getText();

       Assert.assertEquals(lSev, lSt);
    }

    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() {
     defectP.ReportB.click();
    }

    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears()throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
        String con = driver.switchTo().alert().getText();
        Boolean confirm = false
                if(con != null){
                    confirm = true;
                }
                Assert.assertTrue(con);
    }

    @When("The employee types in steps with")
    public void the_employee_types_in_steps_with(String docString) {
        defectP.stepps.sendKeys("This is a test steps example");
    }
}
