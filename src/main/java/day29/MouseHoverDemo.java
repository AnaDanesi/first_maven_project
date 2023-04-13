package day29;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/*
Mouse actions
----------

Mouse hover  -	 moveToElement(Element)
Right click      -  contextClick(Element)
Double click  - doubleClick(Element)
Drag and drop - dragAndDrop()
slider --- dragAndDropBy(Element, x,y);


Actions - class provided by selenium webdriver.

build() - create an action
perform() - can complete the action
 */
public class MouseHoverDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();

        WebElement desktops=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));

        Actions act=new Actions(driver);   //we have to pass the driver in the actions class object

        //Mouse hover

        //act.moveToElement(desktops).moveToElement(mac).click().build().perform();  //creating action, then performing
        act.moveToElement(desktops).moveToElement(mac).click().perform();   //directly performing action



    }
}
