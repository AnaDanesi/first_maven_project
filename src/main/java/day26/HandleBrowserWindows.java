package day26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
handle browser windows
-----

getWindowHandle() - return id of single window( in which driver focused)
getWindowHandles()- returns id's of multiple windows

driver.switchTo().window(window id)

driver.switchTo().window(window id).getTitle()
 */

public class HandleBrowserWindows {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        //Approach1

        //capture id's for browser windows
        Set<String> windowIDs=driver.getWindowHandles();   //we have stored 2 window id, with set we cant use the get method and individual values
        List <String>windowIDsList=new ArrayList(windowIDs);  //we convert set to list collection

        String parentWindowID=windowIDsList.get(0);
        String childWindowID=windowIDsList.get(1);

        //switch to child window
        driver.switchTo().window(childWindowID);
        driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();

        //switch to parent window
        driver.switchTo().window(parentWindowID);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("anabella");




    }
}
