package day19;
/*CSS- Cascading Style Sheets

HTML     CSS   JavaScript

sumbit

driver.findElement(By.cssSelector(selector))

css selectors
-
tag id     #
	Ex:    input#small-searchterms
		  #small-searchterms


tag class     .
	Ex:   input.search-box-text
 		 .search-box-text

tag attribute    []
	Ex:   input[name='q']
		 [name='q']



tag class attribute    .  []

	Ex:  input.search-box-text[name='q']
		.search-box-text[name='q']


 */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class CSSSelectorsDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //tag and id
        //driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
        //driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("MacBook");

        //tag and class
        //driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("MacBook");
        //driver.findElement(By.cssSelector(".search-box-text")).sendKeys("MacBook");

        //tag and attribute
        //driver.findElement(By.cssSelector("input[name='q']")).sendKeys("MacBook");
        //driver.findElement(By.cssSelector("[name='q']")).sendKeys("MacBook");

        //tag class and attribute
        //driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("MacBook");
        driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("MacBook");


    }

}
