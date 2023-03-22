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

        //isDisplayed() - for logo element
        //WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        //System.out.println("display status of logo:  "+logo.isDisplayed());
        //or  this:
        boolean status=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
        System.out.println(status);

        //isDisplayed() and isEnabled() - for search box
        WebElement searchbox=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        System.out.println("Display status:  "+searchbox.isDisplayed());
        System.out.println("Display status:  "+searchbox.isEnabled());

        //isSelected()
        WebElement male_rd=driver.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement female_rd=driver.findElement(By.xpath("//input[@id='gender-female']"));

        //Before selection
        System.out.println("Before selection........");
        System.out.println(male_rd.isSelected()); //false
        System.out.println(female_rd.isSelected()); //false

        //After selection of male radio button
        male_rd.click();
        System.out.println("After selection of male radio button:.....");
        System.out.println(male_rd.isSelected()); //true
        System.out.println(female_rd.isSelected()); //false

        //After selection of female radio button
        female_rd.click();
        System.out.println("After selection of male radio button:.....");
        System.out.println(male_rd.isSelected()); // false
        System.out.println(female_rd.isSelected()); // true

        //we cant click the 2 buttons at the same time! remember
    }
}
