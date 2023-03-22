package day23;
/*-------
wait commands


wait statements will be used to solve synchronization problem in automation.


Thread.sleep(ms)

implicit wait
explicite wait/ fluent state

sleep() : provided by java itself( not selenium command)
------------
Adv:
1) easy to use

DisAdvantage:

1) if the time is not sufficient then you will get exception
2) it will wait ofr maximum time out. this will reduce the performance script.
3) multiple times
*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SleepStatements {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(options);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");


    }
}
