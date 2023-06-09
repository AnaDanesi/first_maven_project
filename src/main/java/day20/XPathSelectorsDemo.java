package day20;
/*XPath
--------
Address of an element
DOM - Document Object Model

2 kinds of xpaths
------
1) Absolute xpath( full xpath)

	/html/body/header/div/div/div[1]/div/a/img

2) Relative xpath ( partial xpath)

	//div[@id="logo"]/a/img

	//img[@title='Your Store']

differences....

which one you will prefer?
	Relative xpath

why?
	bcoz absolute xpath wont work if there are any changes in web page.


How to write our own xpath?

	//*[@attribute='value']
	//tagname[@attribute='value']


How to generate xpath automatically?
  1) using developer tools
 2) using selectors hub - extension of browser

//img[@title='Your Store']

xpath having multiple attributes
xpath functions - text(), normalized-pace(), contains() start-with()
xpath operators - and      or
xpath axes - following, preceding, sibling, parent, self, ancestor etc.....
How to locate elements who attributes are dynamically changing

*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathSelectorsDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();

        String productname=driver.findElement(By.xpath("//a[normalize-space()='MacBook]")).getText();
        //String productname=driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[2]/div[1]/form/div/div[1]/a")).getText();
        System.out.println(productname);
    }
}
