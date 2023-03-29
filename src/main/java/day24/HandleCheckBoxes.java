package day24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class HandleCheckBoxes {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10
        ));

        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();

        //select specific checkbox (only one)
        //driver.findElement(By.xpath("//input[@id='monday']")).click();

        //total number of checkboxes
        List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        System.out.println("total number of checkboxes= "+checkboxes.size()); //7

        //select all the checkboxes (2 ways)
        /*for(int i=0;i<checkboxes.size();i++) {
            checkboxes.get(i).click();
        }

        for(WebElement chbox:checkboxes) {
            chbox.click();
        }*/

        //select las 2 checkboxes
        //total number of checkboxes-how many checkboxes to be selected=starting index
        /*for (int i=5;i< checkboxes.size();i++) {
            checkboxes.get(i).click();
        }*/

        //select first 2 checkboxes (we cannot do enhanced for loop because we depend on the index
        /*for (int i=0;i<2;i++) {
            checkboxes.get(i).click();
        }*/
        // or for(int i=0;i<checkboxes.size();i++) {
          /*  if (i < 2) {
                checkboxes.get(i).click();
            }
        }*/

        //clear/uncheck checkboxes
        /*for(int i=0;i<checkboxes.size();i++) {
            checkboxes.get(i).click();
        }
        Thread.sleep(4000);
        for(int i=0;i<checkboxes.size();i++) {
            checkboxes.get(i).click();
        }*/

        //clear/uncheck checkboxes
        //using normal for loop
        /*for(int i=0;i<3;i++) {
            checkboxes.get(i).click();
        }
        Thread.sleep(4000);
        for(int i=0;i<checkboxes.size();i++) {
            if (checkboxes.get(i).isSelected()) {
                checkboxes.get(i).click();
            }
        }*/

        //using for each loop
        for(int i=0;i<3;i++) {
            checkboxes.get(i).click();
        }
        Thread.sleep(4000);

        for (WebElement chbox:checkboxes) {
            if (chbox.isSelected()) {
                chbox.click();
            }
        }


    }

}
