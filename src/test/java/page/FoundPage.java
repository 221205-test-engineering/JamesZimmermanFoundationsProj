package page;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FoundPage {

    public static FoundPage nav;
    public WebDriver driver;

    public FoundPage(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
    }
    @FindBy(xpath ="/html/body/div/fieldset/input[1]")
    public WebElement user;

    @FindBy(xpath ="/html/body/div/fieldset/input[2]")
    public WebElement pass;

    @FindBy(xpath ="/html/body/div/fieldset/button")
    public WebElement sub;

    @FindBy(xpath ="/html/body/div/h1")
    public WebElement role;

    @FindBy(xpath ="/html/body/div/nav/p/text()[2]")
    public WebElement name;

    @FindBy(xpath ="/html/body/div/nav/p/text()[3]")
    public WebElement lName;

    //@FindBy(xpath = "//button[text()='Not Now']")
    // public WebElement nButton;

    @FindBy(xpath ="/html/body/div/nav/a[1]")
    public WebElement matrix;

    @FindBy(xpath ="/html/body/div/nav/a[6]")
    public WebElement home;

    @FindBy(xpath ="/html/body/div/nav/a[2]")
    public WebElement testcase;

}
