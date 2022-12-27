package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage {
    public WebDriver driver;
    public WebElement tC;


    public TestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td[4]/button")
    public WebElement detailB;

    @FindBy(xpath ="/html/body/div[1]/form/fieldset/textarea[1]")
    public WebElement des;

    @FindBy(xpath ="/html/body/div[1]/form/fieldset/textarea[2]")
    public WebElement inp;

    @FindBy(xpath ="/html/body/div[1]/form/fieldset/button")
    public WebElement SubI;

    //log in
    @FindBy(xpath ="/html/body/div/fieldset/input[1]")
    public WebElement userName;

    @FindBy(xpath ="/html/body/div/fieldset/input[2]")
    public WebElement passWord;

    @FindBy(xpath ="/html/body/div/fieldset/button")
    public WebElement subMit;

    @FindBy(linkText ="<a href=\"/testcases\">Test Cases</a>")
    public WebElement testCaseLink;

    @FindBy(xpath ="//tbody/tr[last()]/td[2]")
    public WebElement bList;

    @FindBy(xpath ="/html/body/div[1]/table/tbody/tr[6]/td[4]/button")
    public WebElement bButton;

    @FindBy(xpath ="/html/body/div[3]/div/div/h3/text()[2]")
    public WebElement testId;

    @FindBy(xpath ="/html/body/div[3]/div/div/p[6]")
    public WebElement pBy;

    @FindBy(xpath ="/html/body/div[3]/div/div/button[1]")
    public WebElement closeB;

    @FindBy(xpath ="/html/body/div[3]/div/div/button[2]/a")
    public WebElement editB;

    @FindBy(xpath ="/html/body/div/button")
    public WebElement editB1;

    @FindBy(xpath ="/html/body/div/fieldset[1]/textarea[1]")
    public WebElement descr;

    @FindBy(xpath ="/html/body/div/fieldset[1]/textarea[2]")
    public WebElement inStep;

    @FindBy(xpath ="/html/body/div/fieldset[1]/input")
    public WebElement check;

    @FindBy(xpath ="/html/body/div/fieldset[1]/select")
    public WebElement dropD;

    @FindBy(xpath ="/html/body/div/fieldset[2]/select")
    public WebElement rDrop;

    @FindBy(xpath ="/html/body/div/fieldset[2]/textarea")
    public WebElement writeTe;

    @FindBy(xpath ="/html/body/div/button[2]")
    public WebElement subTest;

    @FindBy(xpath ="/html/body/div/button[1]")
    public WebElement resetB;
}
