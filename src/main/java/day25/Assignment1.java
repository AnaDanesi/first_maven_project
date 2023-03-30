package day25;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/*1) Auto suggetion box
https://www.bing.com/

 */
public class Assignment1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();

        Thread.sleep(8000);

        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("chat gpt");
        Thread.sleep(3000);

        List<WebElement> list=driver.findElements(By.xpath("//ul[@id='sa_ul']/li"));
        System.out.println("Number of suggestions:  "+list.size());

        //select a suggestion from the list
        for (int i=0;i<list.size();i++){
            String text=list.get(i).getText(); //it returns the 8 suggestions with system.out.println
            System.out.println("Suggestions:  "+list.get(i).getText());
            if (text.equals("chat gpt 4")){ //capturing one element
                list.get(i).click();
                break;
            }

        }



    }
}
