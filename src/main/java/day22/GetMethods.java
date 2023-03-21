package day22;
/*Day-22
---------
1) get methods
2) conditional methods
3) Browser methods
4) Navigational methods
5) wait methods

get methods  - we can these methods through webdriver instance
----------
get(url)
getTitle()
getCurrentURL()
getPageSource()
getWindowHandle()
getwindowHandles()
 */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        System.out.println("title of the page:  "+driver.getTitle());

        System.out.println("current url:   "+driver.getCurrentUrl());

        System.out.println("Page source:   ");
        String ps=driver.getPageSource();
        System.out.println(ps);
        System.out.println(ps.contains("html"));


    }
}
