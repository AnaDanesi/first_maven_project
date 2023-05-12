package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
2) XML - Parallel testing

step1) create test case
step 2) create xml file to run the test
step3) pass browser name parameter from the xml to setup() method
step4 ) execute test case on chrome & edge ( serial execution)
step5 ) execute test case on chrome & edge ( parallel execution)

I cant test this, we have to test the xml file. because it depends on it
 */
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParamTest {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser","url"})
    void setup(String br,String appurl) throws InterruptedException
    {
        if(br.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver=new ChromeDriver(options);
        }
        else if(br.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options=new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver=new EdgeDriver(options);
        }
        else
        {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options=new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");
            driver=new FirefoxDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(appurl);
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test(priority=1)
    void testLogo()
    {
        try
        {
            boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
            Assert.assertEquals(status,true);
        }
        catch(Exception e)
        {
            Assert.fail();
        }
    }

    @Test(priority=2)
    void testHomePageTitle()
    {
        Assert.assertEquals(driver.getTitle(),"OrangeHRM","Titles are bot matched..");

    }

    @AfterClass
    void closeApp()
    {
        driver.quit();
    }
}