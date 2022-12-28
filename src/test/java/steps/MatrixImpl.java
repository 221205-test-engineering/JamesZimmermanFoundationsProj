package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.matrixPage;
import runner.foundRunner;

import java.time.Duration;

public class MatrixImpl {

    public WebDriver driver = foundRunner.driver;
    public matrixPage matrices = foundRunner.matrices;


    @When("The manager chooses to create a new matrix")
    public void the_manager_chooses_to_create_a_new_matrix() {
      //  new WebDriverWait(driver, Duration.ofSeconds(5))
      //          .until(ExpectedConditions.elementToBeClickable(matrices.createM));

      matrices.createM.click();

    }

    @When("The manager creates a title for the matrix")
    public void the_manager_creates_a_title_for_the_matrix() {
        matrices.maTitle.sendKeys("My Title");
    }

    @When("The manager adds requirements to the matrix")
    public void the_manager_adds_requirements_to_the_matrix() {
        matrices.userSt.sendKeys("Lost bananas");
        Select select = new Select(driver.findElement(By.xpath("/html/body/div/fieldset/table/tbody/tr/td[2]/select")));
        select.selectByIndex(3);
        matrices.notes.sendKeys("Its bananas");
        matrices.requireB.click();
    }

    @When("The manager saves the matrix")
    public void the_manager_saves_the_matrix() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/button")));
    matrices.saveB.click();
    }

    @Then("An alert with a success message should appear")
    public void an_alert_with_a_success_message_should_appear() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());

        Alert aM = driver.switchTo().alert();

        aM.accept();

    }

    @Given("The manager is on the matrix homepage")
    public void the_manager_is_on_the_matrix_homepage() {

        String MatrixHome = "https://bugcatcher-dan.coe.revaturelabs.com/matrices";
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(matrices.maTitle));
        driver.get(MatrixHome);
        try{
            Assert.assertEquals(MatrixHome ,driver.getCurrentUrl());
            System.out.println("The manager is on the Matrix Page");
        }catch(Throwable pageNavigationError){
            pageNavigationError.printStackTrace();
            System.out.println("Incorrect URL");
        }
    }
    @Given("The manager has selected the matrix")
    public void the_manager_has_selected_the_matrix() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/button")));
        matrices.showB.click();
    }

    @When("The manager adds a defect")
    public void the_manager_adds_a_defect() {
        matrices.editB.click();
        Select se = new Select(driver.findElement(By.xpath("/html/body/div/ul/li[4]/div/div/div/table/tbody/tr/td[6]/button")));
        se.selectByIndex(5);

    }

    @When("The manager confirms their changes")
    public void the_manager_confirms_their_changes() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/button")));
    matrices.saveR.click();
    }

    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());

       String alertSave = driver.switchTo().alert().getText();

       Assert.assertEquals("Matrix Saved", alertSave);
       driver.switchTo().alert().accept();
    }

    @When("The manager adds a Test Cases")
    public void the_manager_adds_a_test_cases() {
        Select sel = new Select(driver.findElement(By.xpath("/html/body/div/ul/li[4]/div/div/div/ul[1]/li/input")));
        sel.selectByIndex(2);

    }
}