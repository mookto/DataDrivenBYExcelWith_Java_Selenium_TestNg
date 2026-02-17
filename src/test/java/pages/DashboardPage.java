package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DashboardPage {
    WebDriver driver;

    @FindBy(xpath = "//h5[contains(text(),'Dashboard')]")
    WebElement dashboardTab;
    @FindBy(xpath = "//p[contains(text(),'Payroll Management')]")
    WebElement payrollManagementMenu;

    @FindBy(xpath = "//p[normalize-space()='Salary']")
    WebElement salaryMenu;
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void salary_menu() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // 10 seconds timeout

        wait.until(ExpectedConditions.elementToBeClickable(payrollManagementMenu)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(salaryMenu)).click();
    }

}