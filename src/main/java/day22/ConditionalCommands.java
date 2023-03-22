package day22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
conditional commands - access these commands thorugh WebElement
----------------------
Returns true/false ( boolean values)

isDisplayed()
isEnabled()
isSelected()*/

public class ConditionalCommands {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(options);

        driver.get("https://demo.nopcommerce.com/register");
        driver.manage().window().maximize();

        //isDisplayed()

        //WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        //System.out.println("display status of logo:  "+logo.isDisplayed());
        //or  this:
        boolean status=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
        System.out.println(status);




    }
}
