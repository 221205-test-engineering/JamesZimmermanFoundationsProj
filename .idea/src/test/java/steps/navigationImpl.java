package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleContains("Manager Home"));
        driver.get(expectedUrl);
        try{
            Assert.assertEquals(expectedUrl ,driver.getCurrentUrl());
            System.out.println("Correct URL");
        }catch(Throwable pageNavigationError){
            pageNavigationError.printStackTrace();
            System.out.println("Incorrect URL");
        }
    }
    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeSelected(By.xpath("/html/body/div/nav/a[1]")));

        String matrixT = nav.matrix.getText();
        String testC = nav.testcase.getText();
        String dR = nav.defectR.getText();
        String dO = nav.defectO.getText();

        Assert.assertEquals(matrixT,"Matrices");
        Assert.assertEquals(testC,"Test Cases");
        Assert.assertEquals(dR,"Report a Defect");
        Assert.assertEquals(dO,"Defect Overview");
    }
    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/nav/a[1]")));
        nav.matrix.click();
    }
    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        String map = nav.mP.getText();
        Assert.assertEquals("Matrices",map);
    }
    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
       nav.driver.navigate().back();
    }
    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home(String home) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        String sH = "Home";
        Assert.assertEquals(sH, home);
    }
    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() {
        nav.testcase.click();
    }
    @When("The manager clicks on {string}")
    public void the_manager_clicks_on(String link) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id(link)));
        driver.findElement(By.id(link)).click();

    }
    @Then("The title of page should be {string}")
    public void the_title_of_page_should_be(String title) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeSelected(By.xpath("/html/body/div/h1")));
        Assert.assertEquals(title,"Matrices");
        Assert.assertEquals(title,"Test Cases");
        Assert.assertEquals(title,"Report a Defect");
        Assert.assertEquals(title,"Defect Overview");
    }
}
