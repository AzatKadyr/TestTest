package avtobys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static avtobys.variable.baseUrl;

public class DirectoryElements {
    WebDriver driver;
    public DirectoryElements(WebDriver driver) {this.driver = driver;}

    @FindBy(xpath = "//div[text()=' Справочники ']")
    private WebElement elementMenu;

    public void open(String pageurl) {
        driver.get(baseUrl+ pageurl);
        driver.manage().window().maximize();
    }

    public void clickMenu(){
        elementMenu.click();
    }
}

