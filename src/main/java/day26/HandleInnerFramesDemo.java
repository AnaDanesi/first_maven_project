package day26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HandleInnerFramesDemo {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        //frame1 (same with frame2, frame4 and frame5)
        WebElement frm1=driver.findElement(By.xpath("/html/frameset/frame[1]")); //frame has no name
        driver.switchTo().frame(frm1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("12345");

        driver.switchTo().defaultContent();

        //frame3 (it has a nested iframe)
        WebElement frm3=driver.findElement(By.xpath("/html/frameset/frameset/frame[2]"));
        driver.switchTo().frame(frm3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("456789");

        //inner iframe (inside frame3)
        driver.switchTo().frame(0);  //if we have only 1 frame, we can do index
        driver.findElement(By.cssSelector("div.AB7Lab")).click();  //select first radio button in iframe

        driver.switchTo().defaultContent();




    }
}
