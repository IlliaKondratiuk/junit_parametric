package config;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class Base {

    public static WebDriver driver;

    @BeforeClass
    public static void base_before(){
        driver = Config.create(Drivers.CHROME);
    }

    @AfterClass
    public static void base_after(){
        driver.quit();
    }

}