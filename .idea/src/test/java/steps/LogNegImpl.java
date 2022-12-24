package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.FoundPage;
import runner.foundRunner;

import java.time.Duration;

public class LogNegImpl{

    public WebDriver driver = foundRunner.driver;
    public FoundPage foundNeg = foundRunner.foundNeg;

    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input() {

        foundNeg.user.sendKeys("g8tor");
    }
    @When("The employee types in chomp!! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input(){

        String pmohc = "chomp!!";
        foundNeg.pass.sendKeys(pmohc);
        foundNeg.sub.click();
    }
    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());

        Alert A1 = driver.switchTo().alert();

        A1.accept();

    }
    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {

        foundNeg.user.sendKeys("sicEmDawgs");
    }
    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input(){
       WebElement pass = (WebElement) new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/fieldset/input[2]")));

        foundNeg.pass.sendKeys("natchamps");
        foundNeg.sub.click();
    }
    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found()throws InterruptedException{
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());



        Alert A2 = driver.switchTo().alert();
        A2.accept();
    }
}
