package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*Assignement
----------------
1) Launch browser
2) open url
	URL: https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
3) Provide username  - admin@yourstore.com
4) Provide password  - admin
5) Click on Login button
6) Verify the title of dashboard page
	Exp title : Dashboard / nopCommerce administration
7) Verify Dasboad

ref
----
WebElement  txtemailbox=driver.findElement(By.name("username"));
txtemailbox.clear();
txtemailbox.sendKeys("email..");

driver.findElement(By.id("Email"));
*/
public class Assignment {

    public static void main(String[] args) throws InterruptedException {

        //1) Launch browser
        WebDriver driver=new ChromeDriver(); //for all browsers

        //2) Open url
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.manage().window().maximize(); //to see full window , chain method
        Thread.sleep(5000); //the page is slow, we have to put this

        //3) Provide username  - admin@yourstore.com
        WebElement txtemailbox=driver.findElement(By.name("Email"));
        txtemailbox.clear();
        txtemailbox.sendKeys("admin@yourstore.com");

        //4) Provide password  - admin
        WebElement txtpassword=driver.findElement(By.name("Password"));
        txtpassword.clear();
        txtpassword.sendKeys("admin");

        //5) Click on Login button
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
        Thread.sleep(7000);

        //6) Verify the title of dashboard page
        //	Exp title : Dashboard / nopCommerce administration
        //Title Validation
        String act_title=driver.getTitle();
        String exp_title="Dashboard / nopCommerce administration";

        if(act_title.equals(exp_title)) {
            System.out.println("Test passed");
        }
        else {
            System.out.println("Test failed");
        }

        // Label validation after successful login
        String act_label="";

        try {
            act_label=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/h1")).getText();
        }
        catch(NoSuchElementException e) { }

        String exp_label="Dashboard";

        if (act_label.equals(exp_label)) {
            System.out.println("test passed");
        }
        else {
            System.out.println("test failed");
        }

        //7) close browser
        driver.quit();


    }
}
