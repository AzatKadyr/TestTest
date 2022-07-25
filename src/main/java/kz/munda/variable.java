package kz.munda;

import org.openqa.selenium.WebDriver;

abstract class variable extends RegBuyerPage{


    public static final String baseUrl = "https://mundaworld.com/";
    public static final String registrationUrl = "registration";
    public static final String authUrl = "login";
    public static final String adminCabinetUrl = "http://admin.mundamarket.kz/";
    public static final String logUrl = "http://api.kex888.kz/sendtestlog.php?textlog=";

    public static final String phone = getRandomPhone();
    public static final String falsePhone = "7029677226";
    public static final String email = getRandomEmail();

    public static final String name  = "Testovyi";
    public static final String surname = "Familiya";
    public static final String adress = "Markova 75";
    public static final String postindex = "050000";
    public static final String password = "Qwerty123@";

    public static final String admin = "77029677226";
    public static final String passwordadmin = "123456";

    public static final String downloadsFolder = "out";

    public static final String screenShotsFolder = "out/screenShots";

    public variable(WebDriver driver) {
        super(driver);
    }
}