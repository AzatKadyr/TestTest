package kz.munda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordPage {

    WebDriver driver;
    public ForgotPasswordPage(WebDriver driver) {this.driver = driver;}

    // Элементы страницы

    @FindBy(xpath = "//div[contains(@class, 'form-item')]/a[contains(@href, '/forgot-password')]")
    @CacheLookup
    private WebElement fBtn;

    @FindBy(xpath = "//input[contains(@type, 'tel')]")
    @CacheLookup
    private WebElement inputPhone;

    @FindBy(xpath = "//button[@class = 'button -orange mt-48']")
    @CacheLookup
    private WebElement buttonSend;

    @FindBy(xpath = "//button[@class = 'button -orange mt-48']")
    @CacheLookup
    private WebElement buttonSend1;

    @FindBy(xpath = "//button[@class = 'button -orange mt-48']")
    @CacheLookup
    private WebElement buttonSend3;

    @FindBy(xpath = "//button[@class = 'button -orange']")
    @CacheLookup
    private WebElement buttonSuccess;

    @FindBy(xpath = "//*[@id=\"authLayout\"]/div/div[2]/div/div[1]/div[2]/div[1]/div/div/input[1]")
    @CacheLookup
    private WebElement smscode1;

    @FindBy(xpath = "//*[@id=\"authLayout\"]/div/div[2]/div/div[1]/div[2]/div[1]/div/div/input[2]")
    @CacheLookup
    private WebElement smscode2;

    @FindBy(xpath = "//*[@id=\"authLayout\"]/div/div[2]/div/div[1]/div[2]/div[1]/div/div/input[3]")
    @CacheLookup
    private WebElement smscode3;

    @FindBy(xpath = "//*[@id=\"authLayout\"]/div/div[2]/div/div[1]/div[2]/div[1]/div/div/input[4]")
    @CacheLookup
    private WebElement smscode4;

    @FindBy(xpath = "//input[@type= 'password']")
    @CacheLookup
    private WebElement userPassword;

    @FindBy(xpath = "//*[@id=\"authLayout\"]/div/div[2]/div/div[1]/div[2]/div[2]/div/input")
    @CacheLookup
    private WebElement userPasswordRepeat;

    // Элементы страницы


    public void btnClick() {
        fBtn.click();
    }

    public void btnSend() {
        buttonSend.click();
    }

    public void btnSend1() {
        buttonSend1.click();
    }

    public void btnSend3() {
        buttonSend3.click();
    }

    public void btnSuccess() {
        buttonSuccess.click();
    }

    public void insertPhonee(String phone) {
        inputPhone.sendKeys(phone);
    }

    public void insertPassword(String password) {
        userPassword.sendKeys(password);
        userPasswordRepeat.sendKeys(password);
    }

    public void insertSmscode(String code) {
        smscode1.sendKeys("4");
        smscode2.sendKeys("4");
        smscode3.sendKeys("4");
        smscode4.sendKeys("4");
    }

    public void checkCurrentUrl(String pageUrl) throws Exception {
        System.out.println("Проверка страницы");
        assertEquals(pageUrl, driver.getCurrentUrl(), "Текущая страница недействительна");
    }

}