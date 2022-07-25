package kz.munda;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import static kz.munda.variable.*;
import static org.testng.Assert.assertEquals;

public class RegBuyerPage {

    WebDriver driver;

    public RegBuyerPage(WebDriver driver) {this.driver = driver;}

    // Элементы страницы регистрации

    @FindBy(xpath = "//input[contains(@type, 'tel')]")
    @CacheLookup
    private WebElement userPhone;

    @FindBy(xpath = "//button[@class = 'button -orange button-position mt-48']")
    @CacheLookup
    private WebElement buttonReg;

    @FindBy(xpath = "//button[@class = 'button -orange button-position mt-48']")
    @CacheLookup
    private WebElement buttonNext;

    @FindBy(xpath = "//button[@class = 'button -orange button-position mt-48']")
    @CacheLookup
    private WebElement buttonNext2;

    @FindBy(xpath = "//button[@class = 'button -orange button-position mt-48']")
    @CacheLookup
    private WebElement finishRegBtn;

    @FindBy(xpath = "//input[contains(@type, 'text')]")
    @CacheLookup
    private WebElement userName;

    @FindBy(xpath = "//span[contains(text(), 'Фамилия')]/following-sibling::input")
    @CacheLookup
    private WebElement userSurname;

    @FindBy(xpath = "//input[contains(@type, 'email')]")
    @CacheLookup
    private WebElement userEmail;

    @FindBy(xpath = "//input[contains(@type, 'checkbox')]")
    @CacheLookup
    private WebElement userIagree;

    @FindBy(className = "multiselect")
    @CacheLookup
    private WebElement userCountry;

    @FindBy(className = "multiselect__element")
    @CacheLookup
    private WebElement userCountryElement;

    @FindBy(xpath = "//*[@id=\"authLayout\"]/div/div/div/div[2]/div[4]/div[2]/div")
    @CacheLookup
    private WebElement userCity;

    @FindBy(xpath = "//*[@id=\"authLayout\"]/div/div/div/div[2]/div[4]/div[2]/div/div[3]/ul/li[10]/span")
    @CacheLookup
    private WebElement userCityElement;

    @FindBy(xpath = "//span[contains(text(), 'Адрес*')]/following-sibling::input")
    @CacheLookup
    private WebElement userAdress;

    @FindBy(xpath = "//span[contains(text(), 'Почтовый индекс')]/following-sibling::input")
    @CacheLookup
    private WebElement userPostIndex;

    @FindBy(xpath = "//*[@id=\"authLayout\"]/div/div/div/div[2]/div[4]/div[1]/div/input")
    @CacheLookup
    private WebElement userPassword;

    @FindBy(xpath = "//*[@id=\"authLayout\"]/div/div/div/div[2]/div[4]/div[2]/div/input")
    @CacheLookup
    private WebElement userPasswordRepeat;

    @FindBy(xpath = "//div[contains(@class, 'errors')]")
    @CacheLookup
    private WebElement getAlert;

    @FindBy(xpath = "//div[contains(@class, 'registration__form_title')]")
    @CacheLookup
    private WebElement getTitleDiv;

    public void open(String pageurl) {
        driver.get(baseUrl+ pageurl);
        driver.manage().window().maximize();
    }


    // Элементы страницы регистрации

    // Элементы страницы регистрации


    public void insertPhone(String phone) {
        userPhone.sendKeys(phone);
    }

    public void clickBtn() {
        buttonReg.click();
    }

    public void clickCountry() {
        userCountry.click();
    }

    public void clickCity() {
        userCity.click();
    }

    public void clickCityElement() {
        userCityElement.click();
    }

    public void clickCountryElement() {
        userCountryElement.click();
    }

    public void clickBtnNext() {
        buttonNext.click();
    }

    public void clickBtnNext2() {
        buttonNext2.click();
    }

    public void clickBtnNext3() {
        finishRegBtn.click();
    }

    public void checkErrors(String actual)  throws Exception {
        //assertEquals(getAlert.getText(), actual);
        System.out.println("Ошибка: " + getAlert.getText());
        getpost("Ошибка: " + getAlert.getText());


    }

    public void checkErrorsTitle(String actual)  throws Exception {
        //assertEquals(getTitleDiv.getText(), actual);

        System.out.println("Ошибка: " + getTitleDiv.getText());
        getpost("Ошибка: " + getTitleDiv.getText());



    }

    public void insertPassword(String password) {
        userPassword.sendKeys(password);
    }

    public void insertPassword2(String password) {
        userPasswordRepeat.sendKeys(password);
    }


    public void insertName(String username) {
        userName.sendKeys(username);
    }

    public void insertSurName(String surname) {
        userSurname.sendKeys(surname);
    }

    public void insertAdress(String adress) {
        userAdress.sendKeys(adress);
    }

    public void insertPostIndex(String postindex) {
        userPostIndex.sendKeys(postindex);
    }

    public void clickIagree(){
        userIagree.click();
    }

    public void insertEmail(String email) {
        userEmail.sendKeys(email);
    }

    public void checkCurrentUrl(String pageUrl) throws Exception {
        System.out.println("Проверка страницы");
        assertEquals(baseUrl, pageUrl, "Текущая страница недействительна");

    }


    // Элементы страницы регистрации


    //funct
    public static String getRandomPhone() {
        String s = "123456789";
        StringBuffer phoneNumber = new StringBuffer();

        for (int i = 0; i < 7; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }

        String phone = "787"+phoneNumber.toString();
        return phone;
    }

    public static String getRandomEmail() {
        String s = "123456789";
        StringBuffer phoneNumber = new StringBuffer();

        for (int i = 0; i < 7; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }

        String email = "qa-test" + phoneNumber.toString()+"@test-munda.kz";
        return email;
    }

    public void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void screenShots(String name) {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String fileName = format.format(dateNow) + ".png";

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File
                    (downloadsFolder + "\\A" + name + fileName));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllFilesFolder() {
        for (File myFile : new File(downloadsFolder).listFiles())
            if (myFile.isFile()) myFile.delete();
    }

    public void getpost(String textlog) throws Exception {


        // `HttpURLConnection` connection = (HttpURLConnection) url.openConnection();
        // connection.setRequestMethod("GET");

        String q = textlog;
        String urllog = logUrl + URLEncoder.encode(q, StandardCharsets.UTF_8);

        URL url = new URL(urllog);
        URLConnection connection = url.openConnection();


        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream())))
        {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

/*
    public void uploadImg(){

        String urlAdress = "https://api.kex888.kz/sendtestlog.php?textlog=azaz";
        URL url;
        HttpURLConnection httpURLConnection;
        OutputStream os = null;
        InputStreamReader isR = null;
        BufferedReader bfR = null;

        try {

            Map<String, String> postargs = new HashMap<>();
            postargs.put("user", "Bob");
            postargs.put("password", "1234");

            byte[] out = postargs.toString().getBytes();

            url = new URL(urlAdress);
            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            httpURLConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
            httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            httpURLConnection.setConnectTimeout(200);
            httpURLConnection.setReadTimeout(200);
            httpURLConnection.connect();




            try {
                os = httpURLConnection.getOutputStream();
                os.write(out);
            } catch (Exception e){
                System.err.print(e.getMessage());
            }
            if (HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()){
                isR = new InputStreamReader(httpURLConnection.getInputStream());
                bfR = new BufferedReader(isR);
                while (bfR.readLine() != null){
                    System.out.println("Данные отправлены");
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }


    }
*/
    //funct
}
