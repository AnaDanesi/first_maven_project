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
 // Waiting 30 seconds for an element to be present on the page, checking
   // for its presence once every 5 seconds.

 Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
       .withTimeout(Duration.ofSeconds(30L))
       .pollingEvery(Duration.ofSeconds(5L))
       .ignoring(NoSuchElementException.class);


   WebElement foo = mywait.until(new Function<WebDriver, WebElement>() {
     public WebElement apply(WebDriver driver) {
       return driver.findElement(By.id("foo"));
     }
   });

*/
public class FluentWaitDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //declaration
        /*Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);*/

        FluentWait mywait = new FluentWait(driver);
        mywait.withTimeout(Duration.ofSeconds(30));
        mywait.pollingEvery(Duration.ofSeconds(5));
        mywait.ignoring(NoSuchElementException.class);


        //usage of one element
        WebElement username = (WebElement) mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        username.sendKeys("Admin");
    }

}
