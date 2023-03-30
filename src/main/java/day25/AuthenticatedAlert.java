package day25;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthenticatedAlert {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10)); //explicit for the alert

        //https://the-internet.herokuapp.com/basic_auth
        //https://admin:admin@the-internet.herokuapp.com/basic_auth

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        String text=driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).getText();

        if (text.contains("Congratulations")) {
            System.out.println("Successful login");
        }
        else {
            System.out.println("Login failed");
        }


    }
}
