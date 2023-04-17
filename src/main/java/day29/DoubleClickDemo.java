package day29;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/*
Actions - class provided by selenium webdriver.

build() - create an action
perform() - can complete the action


<input  id='abc' > testing</input>      testing - inner text
findElement(Loc).getText()  ----- testing
findElement(Loc).getAttribute('value')   - return nothing

<input id='abc' value='testing' />       no innertext
findElement(Loc).getText()   - return nothing
findElement(Loc).getAttribute('value') --- testing


getText() --- returns inner text of the element

getAttribute("value") --- testing
getAttribute("id") ------ abc

build().perform()
perfom()
 */
public class DoubleClickDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();

        driver.switchTo().frame("iframeResult"); // switch to frame

        WebElement f1=driver.findElement(By.xpath("//input[@value='Hello World!']"));
        f1.clear();
        f1.sendKeys("Welcome");

        WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

        Actions act=new Actions(driver);

        act.doubleClick(button).perform(); // double click action

        //validation
        WebElement f2=driver.findElement(By.xpath("//body/input[1]"));

        //String copiedtext=f2.getText();  // will not work
        String copiedtext=f2.getAttribute("value");  // this will work

        System.out.println("Copied text is:"+copiedtext);

        if(copiedtext.equals("Welcome"))
        {
            System.out.println("test passed");
        }
        else
        {
            System.out.println("test failed");

        }
    }
}
