package day25;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

/*Auto suggest dropdown(dynamic)
*/
public class AutoSuggestDropdown {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
        Thread.sleep(3000);

        List<WebElement> list=driver.findElements(By.xpath("//li[@class='sbct']"));
        System.out.println("Number of suggestions:  "+list.size());

        //select a suggestion from the list
        for (int i=0;i<list.size();i++){
            String text=list.get(i).getText(); //it returns the 11 suggestions with system.out.println
            if (text.equals("selenium java")){ //capturing one element
                list.get(i).click();
                break;
            }

        }



    }

}
