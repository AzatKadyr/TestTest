package kz.munda;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static kz.munda.variable.*;

public class ForgotPasswordTest extends WebDriverSettings {

    @Test(description = "Страница Забыли пароль", testName = "Забыли пароль", groups = "munda_organization")
    public void forgotPassword() throws Exception {

        AuthBuyerPage authPage = PageFactory.initElements(driver, AuthBuyerPage.class);
        ForgotPasswordPage fpage = PageFactory.initElements(driver, ForgotPasswordPage.class);
        RegBuyerPage bayerPage = PageFactory.initElements(driver, RegBuyerPage.class);

        authPage.open(authUrl);
        authPage.sleep(3000);
        authPage.checkCurrentUrl(authUrl);
        fpage.btnClick();
        authPage.sleep(1000);
        fpage.insertPhonee("7029677226");
        authPage.sleep(1000);
        fpage.btnSend();
        authPage.sleep(1000);
        fpage.insertSmscode("4444");
        authPage.sleep(1000);
        fpage.btnSend1();
        authPage.sleep(1000);
        fpage.insertPassword("123456");
        authPage.sleep(1000);
        fpage.btnSend3();
        authPage.sleep(1000);
        fpage.btnSuccess();
        authPage.sleep(1000);
        fpage.checkCurrentUrl(baseUrl);
        /*
        authPage.insertPhone(staticUser);
        authPage.insertPassword(statisPassword);
        authPage.sleep(2500);
        authPage.buttonClick();
        authPage.sleep(2500);
        authPage.checkCurrentUrl("");
        */

    }

}
