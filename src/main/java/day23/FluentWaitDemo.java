package day23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

/*Fluent wait
------
almost the same as explicit.
difference with explicit, in explicit condition we have timeout, in fluent we have polling and ignoring.
*/
public class FluentWaitDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //declaration
        FluentWait mywait = new FluentWait(driver);
        mywait.withTimeout(Duration.ofSeconds(30));
        mywait.pollingEvery(Duration.ofSeconds(5));
        mywait.ignoring(NoSuchElementException.class);


        //usage of one element
        WebElement username = (WebElement) mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        username.sendKeys("Admin");
    }

}
