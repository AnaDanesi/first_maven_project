package day25;
/*2) Alert (the first), capture the message and close
  https://mail.rediff.com/cgi-bin/login.cgi
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment3 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@title='Sign in']")).click();

        Alert alertwindow=driver.switchTo().alert();
        System.out.println(alertwindow.getText()); //Please enter a valid user name

        alertwindow.accept();

    }
}
