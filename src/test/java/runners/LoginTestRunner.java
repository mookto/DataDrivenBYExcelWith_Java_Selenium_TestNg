package runners;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import resources.ExcelUtils;


import java.io.IOException;
import java.text.ParseException;

public class LoginTestRunner extends BaseTest {

    LoginPage login;
    DashboardPage dashboard;

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws Exception {
        return ExcelUtils.getData("src/test/java/resources/test_data.xlsx", "Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void doLogin(String user, String pass ) throws IOException, ParseException, InterruptedException {
        login = new LoginPage(driver);
        dashboard = new DashboardPage(driver);
       login.login(user,pass);
//        if (expected.equals("success")) {
//            Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"));
//        } else {
//            Assert.assertTrue(driver.findElement(By.cssSelector(".error")).isDisplayed());
//        }

        login.clickLogout();
        Thread.sleep(1000);
    }

    }
