package day21YouTube;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XPathAxesDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
        driver.manage().window().maximize();

        //self
        String text=driver.findElement(By.xpath("//a[normalize-space()='Data Patterns (India']/self::a")).getText();
        System.out.println(text); //Data Patterns (India

        //parent
        text= driver.findElement(By.xpath("//a[normalize-space()='Data Patterns (India']/parent::td")).getText();
        System.out.println(text); //Data Patterns (India

        //child (actually our self node doesnt have a child, so we use the ancestor to go down
        List<WebElement> childs=driver.findElements(By.xpath("//a[normalize-space()='Data Patterns (India']/ancestor::tr/child::td"));
        System.out.println("Number of child element:  "+ childs.size()); //Number of child element : 5

        //ancestor
        text=driver.findElement(By.xpath("//a[normalize-space()='Data Patterns (India']/ancestor::tr")).getText();
        System.out.println(text); //Data Patterns (India A 1,350.20 1,417.00 + 4.95 (it brings all the data of the row because it doesnt have any text



    }
}
