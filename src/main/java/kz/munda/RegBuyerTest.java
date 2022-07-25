package kz.munda;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import static kz.munda.variable.*;

public class RegBuyerTest extends WebDriverSettings{

    @Test(description = "Регистрация покупателя")
    public void regBuyer() throws Exception {

        String testcase = "1.1 Регистрация покупателя (Ожидаемое поведение системы)";
        RegBuyerPage bayerPage = PageFactory.initElements(driver, RegBuyerPage.class);
        //deleteAllFilesFolder();
        bayerPage.getpost("Тест кейс №"+ testcase +" Тестирование начато");

        bayerPage.open(registrationUrl);
        bayerPage.insertPhone(phone);
        bayerPage.clickBtn();
        bayerPage.sleep(2000);
        bayerPage.insertName(name);
        bayerPage.sleep(1000);
        bayerPage.insertSurName(surname);
        bayerPage.sleep(1000);
        bayerPage.insertEmail(email);
        bayerPage.sleep(1000);
        bayerPage.clickIagree();
        bayerPage.sleep(1000);
        bayerPage.screenShots(testcase);
        bayerPage.clickBtnNext();

        bayerPage.sleep(1000);
        bayerPage.clickCountry();
        bayerPage.sleep(1000);
        bayerPage.clickCountryElement();

        bayerPage.sleep(1000);
        bayerPage.clickCity();
        bayerPage.sleep(1000);
        bayerPage.clickCityElement();
        bayerPage.sleep(1000);
        bayerPage.insertAdress(adress);
        bayerPage.sleep(1000);
        bayerPage.insertPostIndex(postindex);
        bayerPage.clickBtnNext2();
        bayerPage.screenShots(testcase);

        bayerPage.sleep(1000);
        bayerPage.insertPassword(password);
        bayerPage.sleep(1000);
        bayerPage.insertPassword2(password);
        bayerPage.screenShots(testcase);
        bayerPage.sleep(1000);
        bayerPage.clickBtnNext3();
        bayerPage.sleep(3000);
        bayerPage.checkCurrentUrl(driver.getCurrentUrl());
        bayerPage.getpost("Тест кейс №"+ testcase +" Тестирование успешно завершено");

    }



    @Test
    public void regBuyerErrorFalsePhone() throws Exception {

        String testcase = "1.1 Регистрация покупателя (Ошибочные данные)";
        RegBuyerPage bayerPage = PageFactory.initElements(driver, RegBuyerPage.class);

        bayerPage.getpost("Тест кейс №"+ testcase +" Тестирование начато");

        bayerPage.open(registrationUrl);
        bayerPage.insertPhone(falsePhone);
        bayerPage.clickBtn();
        bayerPage.sleep(3000);
        bayerPage.getpost("Тест кейс №"+ testcase +" Тестирование успешно завершено");
        bayerPage.screenShots(testcase);

    }

}
