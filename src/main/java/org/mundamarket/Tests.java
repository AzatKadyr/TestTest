package org.mundamarket;

import kz.munda.AuthBuyerPage;
import kz.munda.WebDriverSettings;
import kz.munda.logout;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static kz.munda.variable.*;

public class Tests extends WebDriverSettings {

    kz.munda.function func = PageFactory.initElements(driver, kz.munda.function.class);

    @Test(description = "", testName = "", groups = "munda_organization")
    public void openAdmin() throws Exception {

        UsersPage adminka = PageFactory.initElements(driver, UsersPage.class);

        adminka.open(adminCabinetUrl);
        func.sleep(1000);
        func.checkCurrentUrl(driver.getCurrentUrl(), adminCabinetUrl + "auth/login/");
        adminka.insertLogin(admin);
        func.sleep(1000);
        adminka.insertPassword(passwordadmin);
        func.sleep(1000);
        adminka.clickBtn();
        func.sleep(1000);
        func.checkCurrentUrl(driver.getCurrentUrl(), adminCabinetUrl);
    }

}
