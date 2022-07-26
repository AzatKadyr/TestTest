package kz.munda;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class WebDriverSettings {

    public ChromeDriver driver;

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


    @AfterMethod
    @Attachment
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {

        if (testResult.getStatus() == ITestResult.FAILURE) {
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
            String fileName = format.format(dateNow) + ".jpg";
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + fileName));
        }
    }


}
