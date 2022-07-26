package kz.munda;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static kz.munda.variable.*;


public class AuthBuyerTest extends WebDriverSettings {

    @Test(description = "1.1 Авторизация покупателя", testName = "1.1 Авторизация покупателя")
    public void authBuyer() throws Exception {

        AuthBuyerPage authPage = PageFactory.initElements(driver, AuthBuyerPage.class);
        logout logoutpage = PageFactory.initElements(driver, logout.class);

        authPage.open(authUrl);
        authPage.sleep(3000);
        authPage.checkCurrentUrl(authUrl);
        authPage.insertPhone("7029677226");
        authPage.insertPassword("123456");
        authPage.sleep(2500);
        authPage.buttonClick();
        authPage.sleep(2500);
        authPage.checkCurrentUrl("");
        logoutUser();
    }

    @Test(description = "Выход из сайта", testName = " Выход из сайта")
    public void logoutUser() throws Exception {

        logout logoutpage = PageFactory.initElements(driver, logout.class);
        AuthBuyerPage authPage = PageFactory.initElements(driver, AuthBuyerPage.class);

        authPage.open("");
        authPage.sleep(3000);
        authPage.sleep(2500);
        logoutpage.clickMenu();
        authPage.sleep(2500);
        logoutpage.clickBtn();
        authPage.sleep(10500);
//comment
    }

}
