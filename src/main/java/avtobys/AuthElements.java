package avtobys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static avtobys.variable.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

public class AuthElements {

    WebDriver driver;
    public AuthElements(WebDriver driver) {this.driver = driver;}

    @FindBy(xpath = "//input[@formcontrolname= 'username']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@formcontrolname= 'password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type= 'submit']")
    private WebElement signinBtn;

    public void open(String pageurl) {
        driver.get(baseUrl+ pageurl);
        driver.manage().window().maximize();
    }

    public void inputLogin(String login){
        inputLogin.sendKeys(login);
    }

    public void clearLogin(){
        inputLogin.clear();
    }

    public void clearPassword(){
        inputPassword.clear();
    }
    public void inputPassword(String password){
        inputPassword.sendKeys(password);
    }

    public void signIn(){
        signinBtn.click();
    }

    public void checkCurrentUrl(String pageUrl) {
        System.out.println("Проверка страницы");
        assertEquals(pageUrl, driver.getCurrentUrl(), "Текущая страница недействительна");
    }

    public void getAttributeBtn(String val){
        String elem = signinBtn.getAttribute("disabled");
        System.out.println(elem);
        if(elem!=null){
            assertEquals(elem, val, "Error in script #");
        }else{
            assertEquals(elem, null, "Error in script #");
        }


    }

}
