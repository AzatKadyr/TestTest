package org.mundamarket;

import kz.munda.variable.*;
import kz.munda.WebDriverSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static kz.munda.variable.adminCabinetUrl;
import static kz.munda.variable.baseUrl;
import static org.testng.Assert.assertEquals;

public class UsersPage {

    WebDriver driver;
    public UsersPage(WebDriver driver) {this.driver = driver;}

    // Элементы страницы

    @FindBy(id = "emailaddress")
    @CacheLookup
    private WebElement inputLogin;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement inputPassword;

    @FindBy(xpath = "//button[contains(@class, 'btn btn-primary btn-block')]")
    @CacheLookup
    private WebElement buttonAuth;

    // Элементы страницы

    public void open(String pageurl) {
        driver.get(pageurl);
        driver.manage().window().maximize();
    }

    public void insertLogin(String adminlogin){
        inputLogin.sendKeys(adminlogin);
    }

    public void insertPassword(String adminpassword){
        inputPassword.sendKeys(adminpassword);
    }

    public void clickBtn(){
        buttonAuth.click();
    }


}
