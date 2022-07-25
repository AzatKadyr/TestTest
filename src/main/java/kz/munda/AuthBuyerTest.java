package kz.munda;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static kz.munda.variable.*;

public class AuthBuyerTest extends WebDriverSettings{

    @Test(description = "1.1 Авторизация покупателя")
    public void authBuyer() throws Exception {

        AuthBuyerPage authPage = PageFactory.initElements(driver, AuthBuyerPage.class);

        authPage.open("");
        authPage.sleep(3000);
        authPage.authClick();
        authPage.sleep(3000);
        authPage.checkCurrentUrl(authUrl);
        authPage.insertPhone("7029677226");
        authPage.insertPassword("123456");
        authPage.sleep(2500);
        authPage.buttonClick();
        authPage.sleep(2500);
        authPage.checkCurrentUrl("");
//comment
    }


}
