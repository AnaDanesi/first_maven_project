package day30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
Day-30
---------
Keyboard actions..

JavaScriptExecutor  --- Interface

executeScript() -->
we can execute javascript statements in selenium using this method...

 */
public class InteractWithElementsUsingJS {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        //ChromeDriver driver=new ChromeDriver(options);

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        driver.switchTo().frame(0);

        JavascriptExecutor js=(JavascriptExecutor) driver;
        //JavascriptExecutor js=driver;

        //First name - inputbox
        WebElement inputbox=driver.findElement(By.id("RESULT_TextField-1"));
        js.executeScript("arguments[0].setAttribute('value','john')", inputbox);

        //Radio button
        WebElement male_Rd=driver.findElement(By.id("RESULT_RadioButton-7_0"));
        //male_Rd.click();  //ClickInterceptedException
        js.executeScript("arguments[0].click();",male_Rd);

        //Checkbox
        WebElement chkbox=driver.findElement(By.id("RESULT_CheckBox-8_0"));
        js.executeScript("arguments[0].click();",chkbox);


        //button
        WebElement button=driver.findElement(By.id("FSsubmit"));
        js.executeScript("arguments[0].click();",button);

    }
}
