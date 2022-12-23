package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.FoundPage;
import runner.foundRunner;

import java.util.concurrent.TimeUnit;

public class navigationImpl {

    public WebDriver driver = foundRunner.driver;
    public FoundPage nav = foundRunner.nav;


    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() {
        Assert.assertTrue("the manager is logged in as manager", driver.getTitle().trim().equals("Manager"));
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        String expectedUrl = "https://bugcatcher-dan.coe.revaturelabs.com/managerhome";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("expectedUrl");
        try{
            Assert.assertEquals(expectedUrl ,driver.getCurrentUrl());
            System.out.println("Correct URL");
        }catch(Throwable pageNavigationError){
            pageNavigationError.printStackTrace();
            System.out.println("incorrect URL");
        }
    }
    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
     //getText(); Will work then compair to
    }
    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() {
        nav.matrix.click();
    }
    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page() {

    }

    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {
       nav.driver.navigate().back();
    }
    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home(String home) {
        String sH = "Home";
        Assert.assertEquals(sH, home);
    }
    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() {
        nav.testcase.click();
    }
    @When("The manager clicks on {string}")
    public void the_manager_clicks_on() {

    }
    @Then("The title of page should be {string}")
    public void the_title_of_page_should_be() {

    }
}
