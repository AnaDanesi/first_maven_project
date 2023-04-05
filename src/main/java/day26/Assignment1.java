package day26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

/*
Search, Opening links, switch to browser windows, capture titles, close all browser windows
	https://testautomationpractice.blogspot.com/
 */
public class Assignment1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-input\"]")).sendKeys("automation");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        List<WebElement> list=driver.findElement(By.xpath("//div[@class='wikipedia-search-results']//div")).getText();


        System.out.println("results:  "+list);




    }
}
