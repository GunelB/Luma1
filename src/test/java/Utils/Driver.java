package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.bcel.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class Driver {

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>(); // its a pool of drivers so we can run parallel rtests

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            synchronized (Driver.class) {//it will assign one driver to each test scenario in order to run it parallely
                switch (ConfigReader.getProperties("browser")) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions ops = new ChromeOptions();
                        ops.addArguments("--remote-allow-origins=*");

                        driverPool.set(new ChromeDriver(ops));
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driverPool.set(new EdgeDriver());
                        break;
                    case "chrome-headless":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                        break;
                    default:
                        System.out.println("The Driver is NOT Found");

                }
            }
        }
        return driverPool.get();


    }

  /*  public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }

    }*/



    }
