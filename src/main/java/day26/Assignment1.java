package day26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
Search, Opening links, switch to browser windows, capture titles, close all browser windows
	https://testautomationpractice.blogspot.com/
 */
public class Assignment1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-input\"]")).sendKeys("automation");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='wikipedia-search-results']//div"));

        System.out.println("number of results: " + list.size()); //5

        //Print all the options from dropdown - looping statement normal or enhanced
        //Using normal for loop
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());  //Automation, Automation bias, Automation Master, Automation Studio, Automation of the London Underground
        }

        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > aside:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(4) > a:nth-child(1)")).click();

        //capture id's for browser windows
        Set<String> windowIDs=driver.getWindowHandles();   //we have stored 2 window id, with set we cant use the get method and individual values

        //Approach1 (2 browser windows only) - using List collection

        List <String>windowIDsList=new ArrayList(windowIDs);  //we convert set to list collection

        String parentWindowID=windowIDsList.get(0);
        String childWindowID=windowIDsList.get(1);


        //close parent window
      /*  for (String winID:windowIDs) {
            String title = driver.switchTo().window(winID).getTitle();
            if (title.equals("Automation Testing Practice")) {
                driver.close();
            }
        }*/

        //close child window
        for (String winID:windowIDs) {
            String title = driver.switchTo().window(winID).getTitle();
            if (title.equals("Automation Studio - Wikipedia")) {
                driver.close();
            }
        }

    }
}
