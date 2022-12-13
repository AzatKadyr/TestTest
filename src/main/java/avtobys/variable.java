package avtobys;



public class variable {

    public static final String baseUrl = "https://control.beta.avtobys.kz/";
    public static final String login = "omg-aktobe1";
    public static final String password = "admin";
    public static final String mainpage = baseUrl + "main";
    public static final String falseLogin = "azaza";
    public static final String falsePassword = "adssdaasd";

    public static final String logUrl = "http://api.kex888.kz/sendtestlog.php?textlog=";
    public static final String urlUpload = "http://api.kex888.kz/sendtestlog.php?sendphoto=";

    public static final String downloadsFolder = "out";

    public static final String screenShotsFolder = "out/screenShots";


    //Отправка уведомление, если тестирование успешно прошло
    public static final boolean isSuccessSend = true;
    public static final boolean sendErrorScreenshots = true;
}