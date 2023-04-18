package day29;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsVsAction {

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

        //act.contextClick(button).perform(); //right click, completing the action

        //action interface variable
        Action myaction=act.contextClick(button).build(); //creating an action and storing in a variable
        myaction.perform(); //completing the action
        //act.contextClick(button).build().perform(); //the same as above, but all together


    }
}
