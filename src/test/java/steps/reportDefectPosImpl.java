package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.DefectPage;
import page.FoundPage;
import runner.foundRunner;
import java.time.Duration;

public class reportDefectPosImpl {

    public WebDriver driver = foundRunner.driver;
    public DefectPage defectP = foundRunner.defectP;

    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() {
       String DefectR = "Defect Reporter";
       String DefR = defectP.DefectRep.getText();
       Assert.assertEquals(DefR, DefectR);
    }

    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() {
        defectP.dateIn.click();
    }

    @When("The employee types in Description with")
    public void the_employee_types_in_description_with(String sign) {
        defectP.description.sendKeys(sign);
    }

    @When("The employee types in Steps with")
    public void the_employee_types_in_steps_with(String steper) {
       defectP.stepps.sendKeys(steper);
    }

    @When("The employee selects {string} priority")
    public void the_employee_selects_priority(String Priority) {
       String pri = defectP.prioritys.getText();

       Assert.assertEquals(pri,Priority);
    }

    @When("The employee selects {string} severity")
    public void the_employee_selects_severity(String sev) {
        String sed = defectP.Severitys.getText();
        Assert.assertEquals(sed,sev);
    }

    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() {
        defectP.tesBut.click();
    }

    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
      String CBR = "Confirm Bug Report?";
      String tesBtn = defectP.tesBut.getText();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());

        Alert A5 = driver.switchTo().alert();
        Assert.assertEquals(CBR,tesBtn);

    }

    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() {
        defectP.tesBut.click();
    }

    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() {
       String defId = defectP.modal.getText();
        String iNum = defectP.inNum.getText();
        String dIfed = "Defect" +iNum+ "created";

        Assert.assertEquals(dIfed,defId);

    }

    @When("The employee clicks close")
    public void the_employee_clicks_close() {
      defectP.closeB.click();
    }

    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(defectP.closeB));
        Boolean b = false;
        if(defectP.closeB == null){
            b = true;
        }
        Assert.assertTrue(b);
    }

}
