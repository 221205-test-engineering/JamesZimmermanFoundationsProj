package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FoundPage {

    public WebDriver driver;

    public FoundPage(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
    }
    @FindBy(xpath ="//p")
    public WebElement message;
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

    @FindBy(xpath = "/html/body/div/nav")
    public WebElement n;
    @FindBy(xpath = "//a[1]")
    public WebElement matrix;

    @FindBy(xpath ="/html/body/div/h1")
    public WebElement mP;
    @FindBy(xpath = "//a[2]")
    public WebElement testcase;
    @FindBy(xpath = "//a[3]")
    public WebElement defectR;
    @FindBy(xpath = "//a[4]")
    public WebElement defectO;

    @FindBy(xpath ="/html/body/div/nav/a[6]")
    public WebElement home;
}
