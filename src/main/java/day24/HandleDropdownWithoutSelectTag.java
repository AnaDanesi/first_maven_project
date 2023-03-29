package day24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class HandleDropdownWithoutSelectTag {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10
        ));

        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();

        //clicking on the dropdown
        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
        List<WebElement> drop_options= driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//li//label"));

        //Find total number of options
        System.out.println("Total number of options:  "+drop_options.size()); //total 14

        //Print all the options from dropdown - looping statement normal or enhanced
        //Using normal for loop
        /*for (int i=0;i< drop_options.size();i++) {
            System.out.println(drop_options.get(i).getText()); //Web Development,jQuery,Bootstrap,HTML,CSS,Angular,Programming Languages,Java,C#,Python,Databases,MySQL,Oracle,MS SQL Server
        }*/

        //Select options from dropdown
        for (int i=0;i<drop_options.size();i++) {
            String drop_option=drop_options.get(i).getText();

            if (drop_option.equals("Java") || drop_option.equals("Python")) {
                drop_options.get(i).click();
                 }
        }





    }
}
