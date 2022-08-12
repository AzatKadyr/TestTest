package kz.munda;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static kz.munda.variable.*;

public class RegBuyerTest extends WebDriverSettings{

    TelegramSend telegram = PageFactory.initElements(driver, TelegramSend.class);

    function func = PageFactory.initElements(driver, function.class);


    @Test(description = "Регистрация покупателя", groups = "munda_organization")
    public void regBuyer() throws Exception {

       // String testcase = "1.1 Регистрация покупателя (Ожидаемое поведение системы)";
        RegBuyerPage bayerPage = PageFactory.initElements(driver, RegBuyerPage.class);
        //deleteAllFilesFolder();
        //telegram.getpost("Тест кейс №"+ testcase +" Тестирование начато");
        String randomphone = phone;

        bayerPage.open(registrationUrl);
        bayerPage.insertPhone(randomphone);
        bayerPage.clickBtn();
        func.sleep(2000);

        String code = telegram.getCode(randomphone);
        System.out.println("Code iz sms:" + code);
        bayerPage.insertSmsCode(code);
        func.sleep(2000);
        bayerPage.smsBtnClick();

        func.sleep(2000);
        bayerPage.insertName(name);
        func.sleep(1000);
        bayerPage.insertSurName(surname);
        func.sleep(1000);
        bayerPage.insertEmail(email);
        func.sleep(1000);
        bayerPage.clickIagree();
        func.sleep(1000);
       // bayerPage.screenShots(testcase);
        bayerPage.clickBtnNext();

        func.sleep(1000);
        bayerPage.clickCountry();
        func.sleep(1000);
        bayerPage.clickCountryElement();

        func.sleep(1000);
        bayerPage.clickCity();
        func.sleep(1000);
        bayerPage.clickCityElement();
        func.sleep(1000);
        bayerPage.insertAdress(adress);
        func.sleep(1000);
        bayerPage.insertPostIndex(postindex);
        bayerPage.clickBtnNext2();
        //bayerPage.screenShots(testcase);

        func.sleep(1000);
        bayerPage.insertPassword(password);
        func.sleep(1000);
        bayerPage.insertPassword2(password);
        //bayerPage.screenShots(testcase);
        func.sleep(1000);
        bayerPage.clickBtnNext3();
        func.sleep(3000);
        bayerPage.checkCurrentUrl(baseUrl);
       // telegram.getpost("Тест кейс №"+ testcase +" Тестирование успешно завершено");

    }



    @Test(enabled = false)
    public void regBuyerErrorFalsePhone() throws Exception {

        String testcase = "1.1 Регистрация покупателя (Ошибочные данные)";
        RegBuyerPage bayerPage = PageFactory.initElements(driver, RegBuyerPage.class);

        telegram.getpost("Тест кейс №"+ testcase +" Тестирование начато");

        bayerPage.open(registrationUrl);
        bayerPage.insertPhone(falsePhone);
        bayerPage.clickBtn();
        func.sleep(3000);
        telegram.getpost("Тест кейс №"+ testcase +" Тестирование успешно завершено");
        bayerPage.screenShots(testcase);
        func.sleep(3000);
        bayerPage.checkCurrentUrl(baseUrl + registrationUrl);

    }


    @Test()
    public void testSms() throws Exception {

        telegram.getCode("77029677226");

    }
}
