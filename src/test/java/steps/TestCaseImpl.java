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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.TestPage;
import runner.foundRunner;

import java.time.Duration;

public class TestCaseImpl {

    public WebDriver driver = foundRunner.driver;
    public TestPage testC = foundRunner.testC;
    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() {

        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=20");
        testC.userName.sendKeys("cavalier89");
        testC.passWord.sendKeys("alucard");
        testC.subMit.click();

        testC.testCaseLink.click();
        Assert.assertEquals("Tester Case Dashboard",driver.getTitle());
    }

    @When("The tester types Description into input with")
    public void the_tester_types_description_into_input_with(String docString) {
        testC.des.sendKeys(docString);
    }
    @When("The tester types Steps into input with")
    public void the_tester_types_steps_into_input_with(String inpString) {
       testC.inp.sendKeys(inpString);
    }

    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() {
        testC.SubI.click();
    }

    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(testC.bList)));
        String exp = "Verify that usernames cannot have illegal characters";
        String actD = testC.bList.getText();
        Assert.assertEquals(exp,actD);
    }

    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() {
        Assert.assertEquals("UNEXECUTED",testC.bList.getText());
    }

    @When("The tester presses on details")
    public void the_tester_presses_on_details() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(testC.bButton));
        testC.bButton.click();
    }

    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() {
      Boolean cI = false;
      if(testC.testId != null){
          cI = true;
      }
      Assert.assertTrue(cI);
    }

    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() {
        Assert.assertEquals("No One", testC.pBy.getText());
    }

    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() {
        testC.closeB.click();
    }

    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {
        Boolean cB = testC.testId.isDisplayed();
        if(testC.testId == null){
            cB = true;
        }
        Assert.assertTrue(cB);
    }

    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() {
       testC.editB.click();
    }

    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("caseeditor"));
        String Cas = driver.getTitle();
         Assert.assertEquals("Case Editor",Cas);
    }

    @When("The tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() {
       testC.editB1.click();
    }

    @When("The tester types in {string} into the description text area")
    public void the_tester_types_in_into_the_description_text_area(String description) {
       testC.descr.sendKeys("Description");
    }

    @When("The tester types in {string} into the steps text area")
    public void the_tester_types_in_into_the_steps_text_area(String step) {
      testC.inStep.sendKeys("Steps");
    }

    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() {
        testC.check.click();
    }

    @When("The tester selects {string} for performed from drop down")
    public void the_tester_selects_for_performed_from_drop_down(String drop) {
       Select s3 = new Select(testC.dropD);


        Assert.assertEquals(s3,drop);
    }

    @When("The tester selects {string} for test result from drop down")
    public void the_tester_selects_for_test_result_from_drop_down(String tres) {
       Select s4 = new Select(testC.rDrop);

       Assert.assertEquals(s4,tres);
    }

    @When("The tester types in {string} into the summary text area")
    public void the_tester_types_in_into_the_summary_text_area(String write) {
     testC.writeTe.sendKeys(write);
    }

    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() {
        testC.subTest.click();
    }

    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());


        String cP = driver.switchTo().alert().getText();

        Assert.assertEquals("Are you sure you want to update the test case?",cP);
        System.out.println(cP);

    }

    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() {
       driver.switchTo().alert().accept();
    }

    @Then("An alert says the test case has been saved")
    public void an_alert_says_the_test_case_has_been_saved() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());


        String sTa = driver.switchTo().alert().getText();

        Assert.assertEquals("Test Case has been Saved",sTa);
        System.out.println(sTa);
        driver.switchTo().alert().accept();
    }

    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() {
       testC.resetB.click();
    }

    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        WebElement Reset = driver.findElement(By.xpath("//fieldset[2]/p"));
        String resetR = Reset.getText();
        Assert.assertEquals("PASS",resetR);
    }

}
