package day22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*browser methods
---------------
close()
- close single browser window

quit()
- close every browser windows
 */
public class BrowserCommands {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(options);

        driver.get("https:/opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        driver.close();


    }
}
