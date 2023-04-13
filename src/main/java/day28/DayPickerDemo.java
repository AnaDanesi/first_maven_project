package day28;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DayPickerDemo {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        driver.switchTo().frame(0); // switch to the frame

        //Approach1 (direct) - 90% of the time we can use this
        //driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("05/15/2023");  // mm/dd/yyyy

        //Approach2

        String year="2020";
        String month="July"; //text format in this date picker
        String day="10";

        driver.findElement(By.xpath("//*[@id='datepicker']")).click();  //will open the date picker

        //Select month and year
        while(true) {
            String mon=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String yr=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(mon.equals(month) && yr.equals(year)) {
                break;
            }

            //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();  //arrow next btn for FUTURE date
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();  //arrow next btn for PAST date

        }

        //Select day
        List<WebElement> allDays=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        for(WebElement date:allDays) {  //with enhanced for loop is easier like here
            if (date.getText().equals(day)) {
                date.click();
                break;
            }
        }

        /*for (int i=0;i<allDays.size();i++) {  // or normal for loop, but it is simplier with enhanced here
            if (allDays.get(i).getText().equals(day)) {
                allDays.get(i).click();
                break;
            }
        }*/








    }
}
