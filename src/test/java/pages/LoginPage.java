package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import resources.ExcelUtils;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @FindBy(xpath = "//input[@id=':r1:']")
    WebElement txtUserName;
    @FindBy(name="password")
    WebElement txtPassword;
    @FindBy(css = "[type=submit]")
    WebElement btnSubmit;
    @FindBy(xpath = "//div[@class='MuiStack-root mui-v8gb54']")
    WebElement userCornerAvatar;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 mui-txzbvm']")
    WebElement btnLogout;



    public void clickLogout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(userCornerAvatar)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnLogout)).click();

    }


//    public void open(String url) {
//        driver.get(url);
//    }

    public void login(String user, String pass) throws InterruptedException {

        txtUserName.sendKeys(user);
        txtPassword.sendKeys(pass);
        Thread.sleep(1000);
        btnSubmit.click();


    }
    }
