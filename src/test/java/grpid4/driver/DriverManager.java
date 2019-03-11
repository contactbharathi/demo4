package grpid4.driver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverManager {

    //Amut
    public static WebDriver driver;
    private String browser = "firefox";

    public DriverManager(){
        PageFactory.initElements(driver,this);
    }

        public void  runOnLocalHost()
        {
        switch (browser) {
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
    }

    public void runOnRemoteHost() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        try {
           // System.out.println("Coming in");
            driver = new RemoteWebDriver(new URL("http://192.168.0.17:4444/wd/hub"),capabilities);
            //192.168.0.17:4444
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void navigateTo(String url){
        driver.get(url);
    }

    public void maxBrowser(){
        driver.manage().window().maximize();
    }

    public void applyImpWait(){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public void closeBrowser(){
        driver.quit();
    }

    public void handleApplicationCookies(){
        driver.findElement(By.linkText("GOT IT")).click();
    }


    public void sleep(int milli){
        try {
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    public Boolean waitUntilElementInvisible(By by) {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }



    public WebElement waitUntilClickable(WebElement element){
        return new WebDriverWait(driver,10).until(
                ExpectedConditions.elementToBeClickable(element));
    }





}

