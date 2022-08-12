package kz.munda;

import static org.testng.Assert.assertEquals;

public class function extends WebDriverSettings{

    public void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void open(String pageurl) {
        driver.get(pageurl);
        driver.manage().window().maximize();
    }

    public void checkCurrentUrl(String facturl, String idealurl) throws Exception {
        System.out.println("Проверка страницы");
        assertEquals(idealurl, facturl, "Текущая страница недействительна");
    }
}
