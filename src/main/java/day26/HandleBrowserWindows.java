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

many browser windows opened
----------------------------------------------
close() - close single browser window which is focud by driver.
quit() - close all the browser windows which are currently opened

3 types of switching commands
---
1) driver.switchTo().alert()
2)  driver.switchTo().frame()
3) driver.switchTo().window()
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

        //capture id's for browser windows
        Set<String> windowIDs=driver.getWindowHandles();   //we have stored 2 window id, with set we cant use the get method and individual values

        //Approach1 (2 browser windows only) - using List colelction

        /*List <String>windowIDsList=new ArrayList(windowIDs);  //we convert set to list collection

        String parentWindowID=windowIDsList.get(0);
        String childWindowID=windowIDsList.get(1);

        //switch to child window
        driver.switchTo().window(childWindowID);
        driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();

        //switch to parent window
        driver.switchTo().window(parentWindowID);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("anabella");



        //Approach2 (from 2 window browsers) - using loops

        for (String winID:windowIDs) {
            String title=driver.switchTo().window(winID).getTitle();
            if (title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM")){
                driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
            }
        }
         */

        //Closing specific browser windows based on our choice

        for (String winID:windowIDs) {
            String title=driver.switchTo().window(winID).getTitle();
            if (title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM")){
                driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
            }
        }


    }
}
