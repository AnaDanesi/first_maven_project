package day25;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*Alerts/popus

1) alert with ok
2) alert with ok & Cancel
3) alert with inputbox along with ok & Cancel
4) alert with no elements

Alert alertwindow=driver.switchTo().alert()

accept()
dismiss()
getText()
*/
public class HandleAlerts {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10)); //explicit for the alert

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        //Alert alertwindow=driver.switchTo().alert();  //with implicit
        Alert alertwindow=mywait.until(ExpectedConditions.alertIsPresent()); //with explicit

        System.out.println(alertwindow.getText());

        //alertwindow.accept(); //this will close alert window using ok button
        alertwindow.dismiss(); //this will close alert window using cancel button





    }
}
