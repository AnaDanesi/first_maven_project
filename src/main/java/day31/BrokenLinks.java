package day31;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);


        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();

        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println("Total number of links:"+links.size()); //48

        int brokenlinks=0;

        for(WebElement linkEle:links)
        {
            String hrefAttValue=linkEle.getAttribute("href");

            // pre-requisite for checking broken link
            if(hrefAttValue==null || hrefAttValue.isEmpty())
            {
                System.out.println("href attribute value is empty.");
                continue;
            }

            //Checking link is broken or not
            URL linkurl=new URL(hrefAttValue); // convert String --> URL format

            HttpURLConnection conn=(HttpURLConnection) linkurl.openConnection(); ////send request to server - open , connect

            conn.connect();

            if(conn.getResponseCode()>=400)
            {
                System.out.println(hrefAttValue+"     "+"====> Broken Link");
                brokenlinks++;
            }
            else
            {
                System.out.println(hrefAttValue+"     "+"====> Not Broken Link");
            }


        }

        System.out.println("total number of broken links:"+brokenlinks);

    }
}
