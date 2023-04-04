package day26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/*
-------
frames/iframe

driver.switchTo().frame(name/id)
driver.switchTo().frame(WebElement)
driver.switchTo().frame(index)

driver.switchTo().defaultContent();

packageListFrame
packageFrame
classFrame

 */
public class HandleFramesDemo1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.manage().window().maximize();

        driver.switchTo().frame("packageListFrame");
        driver.findElement(By.linkText("org.openqa.selenium")).click(); //frame1

        driver.switchTo().defaultContent(); //switch back to main page

        driver.switchTo().frame("packageFrame");
        driver.findElement(By.linkText("WebDriver")).click(); //frame2

        driver.switchTo().defaultContent();

        driver.switchTo().frame("classFrame");
        driver.findElement(By.xpath("This element is in iframe - //a[normalize-space()='org.openqa.selenium']")).click();  //frame3




    }
}
