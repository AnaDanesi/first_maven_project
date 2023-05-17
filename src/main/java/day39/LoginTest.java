package day39;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Day-39
-------
Page object Model pattern
---------------

WebElement ele=driver.findElement(By.id('xyz'));


By loc=By.id('xyz');


driver.finElement(loc).sendKeys()


2 approaches to create page object classes
-----------------------------
1) Without using Page Factory(Normal approach)
2) Using Page Factory

 */

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    //LoginPage lp;
    LoginPage2 lp;

    @BeforeClass
    void setup() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);

    }

    @Test(priority=1)
    void testLogo()
    {
       //lp=new LoginPage(driver);
        lp=new LoginPage2(driver);

        Assert.assertEquals(lp.checkLogoPresence(), true);
    }


    @Test(priority=2)
    void testLogin()
    {
        lp.setUserName("Admin");
        lp.setPassword("admin123");
        lp.clickSubmit();

        Assert.assertEquals(driver.getTitle(),"OrangeHRM");

    }

    @AfterClass
    void tearDown()
    {
        driver.quit();
    }
}
