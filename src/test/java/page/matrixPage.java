package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class matrixPage {

    public WebDriver driver;

    public matrixPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="/html/body/div/button")
    public WebElement createM;

    @FindBy(xpath ="/html/body/div/input")
    public WebElement maTitle;

    @FindBy(xpath = "/html/body/div/fieldset/table/tbody/tr/td[1]/input")
    public WebElement userSt;

    @FindBy(xpath = "/html/body/div/fieldset/table/tbody/tr/td[3]/input")
    public WebElement notes;

    @FindBy(xpath ="/html/body/div/fieldset/button")
    public WebElement requireB;

    @FindBy(xpath ="/html/body/div/button")
    public WebElement saveB;

    //edit Saved matrices
    @FindBy(xpath ="/html/body/div/ul/li[4]/div/span/button")
    public WebElement showB;

    @FindBy(xpath ="/html/body/div/ul/li[4]/div/div/div/table/tbody/tr/td[6]/button")
    public WebElement editB;

    @FindBy(xpath ="/html/body/div/ul/li[4]/div/div/div/button")
    public WebElement saveR;

}

