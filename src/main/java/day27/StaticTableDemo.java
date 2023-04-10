package day27;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class StaticTableDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // 1) Find total number of rows in the table

        // Approach1
        int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("NUmber of rows:   "+rows); //7

        // Approach2
        /*int rows=driver.findElements(By.tagName("tr")).size();
        System.out.println("NUmber of rows:   "+rows); //8, we only can use this if we have only one table */

        // 2) Find total number of columns

        // Approach1
        int cols=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
        System.out.println("NUmber of columns:   "+cols); //4

        // Approach2
        /*int cols=driver.findElements(By.tagName("th")).size();
        System.out.println("NUmber of columns:  "+cols); // 4, we only can use this if we have only one table*/

        // 3) Read specific row and column data
       /* String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]/td[1]")).getText();
        System.out.println(value); // Master in JS*/

        // 4) Read data from all the rows and columns
        for (int r=2;r<=rows;r++) {  //row 1 is the title of every column, that is why we start in row 2
            for (int c=1;c<=cols;c++) {
                String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
                System.out.print(value+"    ");  //print all the data from the table not in table format, (value+"\t") is the same as put (value+"    ")
            }
            System.out.println(); //print all the data in the table format
        }

        // 5) Print book names whose author is Amit
       /* for (int r=2;r<=rows;r++){
            String author= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText(); //author name
            if (author.equals("Amit")){
                String bookname= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText(); //book name
                //System.out.println(bookname); //Learn Selenium and Master in JS
                System.out.println(author+"    "+bookname);
            }
        }*/

        // 6) Find sum of prices for all the books
        int sum=0;
        for (int r=2;r<=rows;r++) {
            String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();
            System.out.println(price); //prices one by one
            sum=sum+Integer.parseInt(price);
        }
        System.out.println("Total price:  "+sum); //7100
    }
}
