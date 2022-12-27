package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class DefectPage {

    public WebDriver driver;



    public DefectPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="/html/body/div/ul")
    public WebElement pend;

    @FindBy(xpath ="/html/body/div/ul/li[3]/div/span/p/b[2]")
    public WebElement select;

    @FindBy(xpath ="/html/body/div/ul/li[3]/div/span/p/text()[1]")
    public WebElement defectD;

    @FindBy(xpath ="/html/body/div/h3")
    public WebElement pList;

    @FindBy(xpath ="/html/body/div/div/button")
    public WebElement buttN;

    ////////////////////////
    @FindBy(xpath ="/html/body/div[1]/h1")
    public WebElement testHome;

    @FindBy(xpath ="/html/body/div[1]/ul")
    public WebElement TDefect;

    @FindBy(xpath ="/html/body/div[1]/ul/li[1]/div/div/div/div[1]/span/button")
    public WebElement changeDf;

    //

    @FindBy(xpath ="/html/body/div[1]/h1")
    public WebElement DefectRep;

    @FindBy(xpath ="/html/body/div[1]/form/input[1]")
    public WebElement dateIn;

    @FindBy(xpath ="/html/body/div[1]/form/textarea[1]")
    public WebElement description;
    @FindBy(xpath ="/html/body/div[1]/form/textarea[2]")
    public WebElement stepps;

    @FindBy(xpath ="/html/body/div[1]/form/input[2]")
    public WebElement prioritys;

    @FindBy(xpath ="/html/body/div[1]/form/input[3]")
    public WebElement Severitys;

    @FindBy(xpath ="/html/body/div[1]/form/button")
    public WebElement tesBut;

    @FindBy(xpath ="/html/body/div[3]/div/div/h4")
    public WebElement modal;

    @FindBy(xpath = "/html/body/div[3]/div/div/h4/text()[2]")
    public WebElement inNum;

    @FindBy(xpath ="/html/body/div[3]/div/div/button")
    public WebElement closeB;

    @FindBy(xpath ="/html/body/div[1]/form/button")
    public WebElement ReportB;
}
