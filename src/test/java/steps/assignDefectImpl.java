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
public class assignDefectImpl {
    public WebDriver driver = foundRunner.driver;
    public DefectPage defectP = foundRunner.defectP;
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {

        String expected = "Assign Defects";
        String actualDefect = defectP.pList.getText();

        Assert.assertEquals(expected,actualDefect);
    }

    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        defectP.select.click();
    }

    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        WebElement ptel = driver.findElement(By.xpath("/html/body/div/div/h4"));
        String ptele = ptel.getText();

        Assert.assertEquals(ptel,ptele);

    }
    @When("The manager selects a tester from the drop down list")
    public void the_manager_selects_a_tester_from_the_drop_down_list() {
     WebElement test = driver.findElement(By.xpath("/html/body/div/div/input"));

        test.sendKeys("cavalier89");
    }

    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        defectP.buttN.click();
    }

    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
       String expectG = "Assign Defects";
       String plop = driver.findElement(By.xpath("/html/body/div/h3")).getText();
       Assert.assertEquals(plop, expectG);
    }

}
