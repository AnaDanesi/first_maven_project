package day29;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LocationOfElement {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));


        System.out.println("Before maximizing window:"+logo.getLocation()); //(208, 180)

        driver.manage().window().maximize();
        System.out.println("After maximizing window:"+logo.getLocation());  //(600, 179)

        driver.manage().window().minimize();
        System.out.println("After minimizing window:"+logo.getLocation()); //(193, 104)

        driver.manage().window().fullscreen();
        System.out.println("After Full screen window:"+logo.getLocation());  //(630, 222)

        Point p=new Point(100,100);
        driver.manage().window().setPosition(p);
        System.out.println("After setting window 100 * 100:"+logo.getLocation());  //(208, 137)

        p=new Point(50,50);
        driver.manage().window().setPosition(p);
        System.out.println("After setting window 50 * 50:"+ ((WebElement) logo).getLocation());  //(208, 137)

    }

}

