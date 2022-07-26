package kz.munda;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static kz.munda.variable.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class WebDriverSettings {

    public ChromeDriver driver;
    TelegramSend telegram = PageFactory.initElements(driver, TelegramSend.class);


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("test start");
    }

    @AfterTest
    public void close() {
        //driver.quit();
        System.out.println("test close");
    }

    @BeforeMethod
    public void viewLog(ITestResult testResult) throws Exception {

        System.out.println(testResult);

    }

    @AfterMethod
    @Attachment
    public void takeScreenShotOnFailure(ITestResult testResult) throws Exception {

        if (testResult.getStatus() == ITestResult.FAILURE) {


            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
            String fileName = format.format(dateNow) + ".jpg";
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String fileTel = "errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + fileName;

            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + fileName));

            String message = "\uD83C\uDD98\uD83C\uDD98\uD83C\uDD98 Произошла ошибка в тестировании. \uD83C\uDD98\uD83C\uDD98\uD83C\uDD98   \uD83D\uDCBB Метод: " + testResult.getMethod() + "\uD83D\uDD0D Название: " + testResult.getTestClass();
            if (sendErrorScreenshots == true) {
                telegram.sendFile(fileTel, fileName, message);

            } else {
                telegram.getpost(message);
            }


        } else {
            if (isSuccessSend == true) {
                String message = "✅✅✅   Тестирование успешно прошло.✅✅✅   \uD83D\uDCBB   Метод: " + testResult.getMethod() + " \uD83D\uDD0D  Название: " + testResult.getTestClass();

                telegram.getpost(message);
            }


        }
    }

}
