package day26;

/*
iframe: put some text, click bold, click clear, put new text
	http://the-internet.herokuapp.com/iframe

 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Assignment2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();

        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']")).sendKeys("Hola Pavan");

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[@title='Bold']")).click();

        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.cssSelector("body p")).clear();


    }
}
