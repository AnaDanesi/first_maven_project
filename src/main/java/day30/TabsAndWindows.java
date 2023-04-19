package day30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TabsAndWindows {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.opencart.com/");

        driver.switchTo().newWindow(WindowType.TAB); // OPENS NEW TAB
        //driver.switchTo().newWindow(WindowType.WINDOW); // OPENS IN ANOTHER WINDOW


        driver.get("https://opensource-demo.orangehrmlive.com/");


    }
}
