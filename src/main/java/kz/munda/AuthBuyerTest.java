package kz.munda;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static kz.munda.variable.*;


public class AuthBuyerTest extends WebDriverSettings {


    function func = PageFactory.initElements(driver, function.class);

    @Test(description = "1.1 Авторизация покупателя", testName = "1.1 Авторизация покупателя", groups = "munda_organization")
    public void authBuyer() throws Exception {

        AuthBuyerPage authPage = PageFactory.initElements(driver, AuthBuyerPage.class);
        logout logoutpage = PageFactory.initElements(driver, logout.class);

        authPage.open(authUrl);
        func.sleep(3000);
        authPage.checkCurrentUrl(authUrl);
        authPage.insertPhone(staticUser);
        authPage.insertPassword(statisPassword);
        func.sleep(2500);
        authPage.buttonClick();
        func.sleep(2500);
        authPage.checkCurrentUrl("");
    }

    @Test(description = "Выход из сайта", testName = " Выход из сайта", groups = "munda_organization", priority = 1)
    public void logoutUser() throws Exception {

        logout logoutpage = PageFactory.initElements(driver, logout.class);
        AuthBuyerPage authPage = PageFactory.initElements(driver, AuthBuyerPage.class);

        authPage.open("");
        func.sleep(3000);
        func.sleep(2500);
        logoutpage.clickMenu();
        func.sleep(2500);
        logoutpage.clickBtn();
        func.sleep(10500);
//comment
    }

}
