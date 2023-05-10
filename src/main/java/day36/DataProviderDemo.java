package day36;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviderDemo {
    WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
    }

    @Test(dataProvider = "dp")
    void testLogin(String email, String pwd) {
        driver.get("https://demo.nopcommerce.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

        String exp_title = "nopCommerce demo store";
        String act_title = driver.getTitle();

        Assert.assertEquals(exp_title, act_title);
    }

    @AfterClass
    void tearDown() {
        driver.close();
    }

    @DataProvider(name = "dp", indices={0,4})
    String[][] loginData() {
        String data[][] = { //2 dimension array to avoid excel for now
                {"abc@gmail.com", "test123"},
                {"pavanol@gmail.com", "test@123"},
                {"pavanoltraining@gmail.com", "test3"},
                {"pualani.concreto@gmail.com", "C5wk8JFBE@iuvQ"},
                {"pualani.concreto@gmail.com", "C5wk8JFBE@iuvQ"}
        };

        return data;
    }

}