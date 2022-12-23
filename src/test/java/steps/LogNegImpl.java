package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.FoundPage;
import runner.foundRunner;

public class LogNegImpl{

    public WebDriver driver = foundRunner.driver;
    public FoundPage foundNeg = foundRunner.foundNeg;

    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input()throws InterruptedException {
        foundNeg.user.sendKeys("g8tor");
        Thread.sleep(5000);
    }
    @When("The employee types in chomp!! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input()throws InterruptedException {
        String pmohc = "chomp!!";
        foundNeg.pass.sendKeys(pmohc);
        foundNeg.sub.click();
        Thread.sleep(5000);
    }
    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        String alert = foundNeg.driver.switchTo().alert().getText();
        Assert.assertEquals("Wrong password for User", alert);
        foundNeg.driver.switchTo().alert().accept();
    }
    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input()throws InterruptedException {
        foundNeg.user.sendKeys("sicEmDawgs");
        Thread.sleep(5000);
    }
    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input()throws InterruptedException {
        foundNeg.pass.sendKeys("natchamps");
        foundNeg.sub.click();
        Thread.sleep(5000);
    }
    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
        String text = foundNeg.driver.switchTo().alert().getText();
        Assert.assertEquals("Username not found", text);
        foundNeg.driver.switchTo().alert().accept();
    }
}
