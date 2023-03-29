package day24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

/*Dropdowns
----------
1) Drop down having select tag in DOM.
2) DropDown not having select tag in DOM ( input/div) - Bootstrap dropdown
3) Auto Suggest drop down ( Dynamic)

Select class

 */

public class HandleDropdownsWithSelectTag {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10
        ));

        driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states");
        driver.manage().window().maximize();

        WebElement drpCountryEle=driver.findElement(By.xpath("//select[@id='country-list']"));
        Select drpCountry=new Select(drpCountryEle); //every option is a webelement

        //1) Selecting an option from the dropdown (3 methods)
        //drpCountry.selectByVisibleText("France");
        //drpCountry.selectByValue("4");  //value is an attribute; 4 is India, if only value attribute is available
        //drpCountry.selectByIndex(5); //USA

        //2) Find total options in the dropdown
        List<WebElement> drop_options=drpCountry.getOptions(); //return list of web elements
        System.out.println("total number of options:  "+drop_options.size()); //6 options total

        //3) Print options in console window - normal for loop
        /*for (int i=0;i<drop_options.size();i++) {
            System.out.println(drop_options.get(i).getText()); //Select Country Brazil China France India USA
        }*/

        //3) Print options in console window - enhanced for loop
        for (WebElement op:drop_options) {
            System.out.println(op.getText()); //Select Country Brazil China France India USA
        }
    }
}
