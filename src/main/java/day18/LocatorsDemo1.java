package day18;

/*1) Identifying elements - Locators
2) Perform actions - Methods

Locator - Locate the web elements

findElement()
findElements()

length - arrays   a.length
lenght() - string   s.lenght()
size()- List, Set, HashMap

findElement(loc) ----> WebElement
findElements(loc) ----> List<WebElement>

Scenario1:  locator is matching with single web element.
-------
findElement(loc) ---->single webelement   WebElement
findElements(loc)--->single webelement		List<WebElement>

Scenario2: locator is matching with multiple web elements
------------------
findElement(loc)---->single webelement(first)    WebElement
findElements(loc) ---> multiple web elements      List<WebElement>

Scenario3: locator is incorect ( No elements are not matching with locator)
------
findElement(loc)----> NoSuchElementException
findElements(loc)--->returns zero

*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorsDemo1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //open url on the browser
        driver.get("https://www.beauty24.com.ar/");
        driver.manage().window().maximize();

       /* //search box
        driver.findElement(By.id("ftBox548be272c1bc43bf929fb9c2db111c1c")).sendKeys("carolina");

        //search button
        driver.findElement(By.id("ftBtn548be272c1bc43bf929fb9c2db111c1c")).click();

        //link text
        driver.findElement(By.linkText("BAD BOY LE PARFUM EDP")).click();
        //driver.findElement(By.partialLinkText("BAD BOY")).click();
        */

        //find elements
        List<WebElement> sliders=driver.findElements(By.className("owl-item"));
        System.out.println("NUmber of sliders:"+sliders.size());

        //total number of images
        List<WebElement> images=driver.findElements(By.tagName("img"));
        System.out.println("number of images:"+images.size());

        driver.quit();

    }

}
