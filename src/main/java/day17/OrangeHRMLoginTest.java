package day17;
/*Test case
--------
1) Launch browser
2) open url
	https://opensource-demo.orangehrmlive.com/
3) Provide username  - Admin
4) Provide password  - admin123
5) Click on Login button
6) Verify the title of dashboard page
	Exp title : OrangeHRM
7) close browser
*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest {

    public static void main(String[] args) throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver","direccion del driver"); // we have to download drivers manually
        //WebDriverManager.chromedriver().setup();//we do not download anything, we add dependencies only, but with the latest version is ok, we dont need to put this

        //1) Launch browser
        //ChromeDriver driver=new ChromeDriver();  only with chrome
        WebDriver driver=new ChromeDriver(); //for all browsers

        //2) open url in the browser
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize(); //to see full window , chain method
        Thread.sleep(5000); //the page is slow, we have to put this

        //3) Provide username  - Admin
        //WebElement txtUsername = driver.findElement(By.name("username")); //pass the locator (attribute)
        //txtUsername.sendKeys("Admin");
        driver.findElement(By.name("username")).sendKeys("Admin");  //one single statement without creating a variable

        //4) Provide password  - admin123
        driver.findElement(By.name("password")).sendKeys("admin123");

        //5) Click on Login button
        //*[@id="app"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button  //we copy xpath because we cannot identify in another way
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(7000);

        //6) Verify the title of dashboard page
        //	Exp title : OrangeHRM
        //Title Validation
        /*String act_title=driver.getTitle();
        String exp_title="OrangeHRM";

        if(act_title.equals(exp_title)) {
            System.out.println("Test passed");
        }
        else {
            System.out.println("Test failed");
        }*/

        // Label validation after successful login
        String act_label="";

        try {
            act_label=driver.findElement(By.xpath("//*[@id='app\']/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
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
        //driver.close();
        driver.quit(); //if it throws an exception we use this

    }
}
