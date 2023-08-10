package com.qa.Base;

import com.qa.TestUtils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase(){
        prop=new Properties();
        File file=new File("C:\\Users\\Amitkumar Patel\\OneDrive\\Desktop\\Naveen Mathur Sessions\\GitTestClass\\src\\main\\java\\com\\qa\\config\\config");
        try {
            FileInputStream fis=new FileInputStream(file);
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void init(){
        String browser=prop.getProperty("browser");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
       // options.addArguments("disable-features=NetworkService");


        if(browser.equals("chrome")){
            driver=new ChromeDriver();

        }else if(browser.equals("firefox")){
            driver=new FirefoxDriver();

        }
        /*EventFiringWebDriver firingWebDriver=new EventFiringWebDriver(driver);
        WebDriverEventHandler handler=new WebDriverEventHandler();
        firingWebDriver.register(handler);
        driver=firingWebDriver;
*/
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
