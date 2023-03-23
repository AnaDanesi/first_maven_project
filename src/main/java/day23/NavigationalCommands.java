package day23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*Navigational commands
-----------------
navigate().to(url)   same as driver.get(url)
navigate().forward()
navigate().back()
navigate().refresh()

driver.navigate().to(url);

driver.manage().window().maximize();

"https://www.google.com"   -----> string

URL myurl=new URL("https://www.google.com")

navigate().to(URL)
    accepts url is URL & String format

driver.get()
	accepts only String format

 */
public class NavigationalCommands {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.amazon.com/");
        System.out.println(driver.getCurrentUrl()); //amazon

        driver.navigate().to("https://www.flipkart.com/");
        System.out.println(driver.getCurrentUrl());  //flipkart

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl()); //amazon

        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl()); //flipkart

        driver.navigate().refresh(); //reload the page

    }

}

