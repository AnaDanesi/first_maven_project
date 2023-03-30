package day25;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/*Alert alertwindow=driver.switchTo().alert()

accept()
dismiss()
getText()
*/

public class AlertWithInputBox {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        Alert alertwindow=driver.switchTo().alert();
        System.out.println(alertwindow.getText());

        alertwindow.sendKeys("Welcome");
        //alertwindow.accept();
        alertwindow.dismiss();

        //validation
        String act_text=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String exp_text="You entered: Welcome";

        if (act_text.equals(exp_text)){
            System.out.println("test passed");
        }
        else {
            System.out.println("test failed");
        }


    }

}
