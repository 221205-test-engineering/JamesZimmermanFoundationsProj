package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.FoundPage;
import runner.foundRunner;


import static org.junit.Assert.assertEquals;
public class FoundStepImpl{
    public WebDriver driver = foundRunner.driver;
    public FoundPage foundPage = foundRunner.foundPage;
    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=20");
    }
    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String username)throws InterruptedException{
        Thread.sleep(5000);
        foundPage.user.sendKeys(username);
    }
    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String password)throws InterruptedException{
        Thread.sleep(5000);
        foundPage.pass.sendKeys(password);
    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button()throws InterruptedException{
        Thread.sleep(5000);
        foundPage.sub.click();
    }
    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String role)throws InterruptedException {
        Thread.sleep(5000);

        assertEquals(role +" Home", driver.getTitle());

        }
    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_on_the_home_page(String name, String lName)throws InterruptedException {
        Thread.sleep(5000);
        WebElement p = driver.findElement((By.xpath("/html/body/div/nav/p")));
        String aL = p.getText();
        System.out.println(aL);
        String[] ar = aL.split(" ");

        String n = ar[1];
        String l = ar[2];


         assertEquals(n, name);
         assertEquals(l, lName);
    }
}

