package day29;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RightClickAction {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();

        WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions act=new Actions(driver);

        //Right Click
        act.contextClick(button).perform();

        driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();  //click on copy option

        Thread.sleep(5000);  //to see the alert window only

        driver.switchTo().alert().accept(); //close the alert window




    }
}
