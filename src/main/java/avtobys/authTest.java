package avtobys;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static avtobys.variable.*;

public class authTest extends webdriver{

    @Test(groups = "auth", priority = 1)
    public void authUserNegative(){

        AuthElements auth = PageFactory.initElements(driver, AuthElements.class);

        auth.open("login");
        auth.inputLogin(falseLogin);
        auth.inputPassword(falsePassword);
        auth.getAttributeBtn("false");
        auth.signIn();
        auth.clearLogin();
        auth.clearPassword();
        auth.inputLogin("");
        auth.inputPassword("");
        auth.signIn();
        auth.getAttributeBtn("true");
    }

    @Test(groups = "auth", priority = 2)
    public void authUser() throws InterruptedException {
        AuthElements auth = PageFactory.initElements(driver, AuthElements.class);

        auth.open("login");
        auth.inputLogin(login);
        auth.inputPassword(password);
        auth.getAttributeBtn("true");
        auth.signIn();
        Thread.sleep(10000);
        auth.checkCurrentUrl(mainpage);

    }


}
