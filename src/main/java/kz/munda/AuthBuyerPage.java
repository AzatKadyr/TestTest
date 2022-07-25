package kz.munda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static kz.munda.variable.*;
import static org.testng.Assert.assertEquals;

public class AuthBuyerPage {

    WebDriver driver;
    public AuthBuyerPage(WebDriver driver) {this.driver = driver;}

    // Элементы страницы авторизации покупателя

    @FindBy(xpath = "//div[contains(@class, 'topPage__links')]/a[contains(@href, '/login')]")
    @CacheLookup
    private WebElement authBtn;

    @FindBy(xpath = "//input[contains(@type, 'tel')]")
    @CacheLookup
    private WebElement inputPhone;

    @FindBy(xpath = "//input[contains(@type, 'password')]")
    @CacheLookup
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@class = 'button -orange mt-48']")
    @CacheLookup
    private WebElement buttonAuth;

    // Элементы страницы авторизации покупателя


    public void open(String pageurl) {
        driver.get(baseUrl+ pageurl);
        driver.manage().window().maximize();
    }

    public void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void insertPhone(String phone) {
        inputPhone.sendKeys(phone);
    }

    public void insertPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void authClick() {
        authBtn.click();
    }

    public void buttonClick() {
        buttonAuth.click();
    }

    public void checkCurrentUrl(String pageUrl) throws Exception {
        System.out.println("Проверка страницы");
        assertEquals(baseUrl+pageUrl, driver.getCurrentUrl(), "Текущая страница недействительна");

    }

}
