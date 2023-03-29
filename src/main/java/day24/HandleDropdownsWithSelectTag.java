package day24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

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
        Select drpCountry=new Select(drpCountryEle);

        //1) Selecting an option from the dropdown
        drpCountry.selectByVisibleText("France");



    }
}
