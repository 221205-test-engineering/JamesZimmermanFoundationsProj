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
import page.FoundPage;
import runner.foundRunner;

import java.time.Duration;


public class navigationImpl {

    public WebDriver driver = foundRunner.driver;
    public FoundPage nav = foundRunner.nav;


    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=20");
        nav.user.sendKeys("g8tor");
        nav.pass.sendKeys("chomp!");
        nav.sub.click();
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        String expectedUrl = "https://bugcatcher-dan.coe.revaturelabs.com/managerhome";

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(nav.message));
        driver.get(expectedUrl);
        try{
            Assert.assertEquals(expectedUrl ,driver.getCurrentUrl());
            System.out.println("The manager is on the Home Page");
        }catch(Throwable pageNavigationError){
            pageNavigationError.printStackTrace();
            System.out.println("Incorrect URL");
        }
    }
    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {

        String matrixT = nav.matrix.getText();
        String testC = nav.testcase.getText();
        String dR = nav.defectR.getText();
        String dO = nav.defectO.getText();

        Assert.assertEquals("Matrices",matrixT);
        Assert.assertEquals("Test Cases",testC);
        Assert.assertEquals("Report a Defect",dR);
        Assert.assertEquals("Defect Overview",dO);
    }
    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices(){

        nav.matrix.click();
    }
    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page() {
        String map = driver.getTitle();
        Assert.assertEquals("Matrices",map);
    }
    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {
       driver.navigate().back();
    }
    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() {

        String sH = driver.getTitle();
        Assert.assertEquals("Manager Home", sH);
    }
    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() {
        nav.testcase.click();
    }
    @When("The manager clicks on {string}")
    public void the_manager_clicks_on(String link) {

        WebElement clicks = driver.findElement(By.linkText(link));
        clicks.click();
    }
    @Then("The title of page should be {string}")
    public void the_title_of_page_should_be(String title) {
     String titlePage = driver.getTitle();
        Assert.assertEquals(titlePage,title);
    }
}
