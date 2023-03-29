package day24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

/*1) Handle dropdown without using Select Class

Select Country & State
https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/

 */
public class AssignmentDropdown {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
        driver.manage().window().maximize();

        //clicking on the dropdown - countries
        driver.findElement(By.xpath("//div[@class='frmDronpDown']/div/descendant::select[contains(@id,'country-list')]")).click();
        List<WebElement> drop_options= driver.findElements(By.xpath("//*[@id=\"country-list\"]/option"));

        //Find total number of options
        //System.out.println("Total number of options:  "+drop_options.size()); //total 6

        //Print all the options from dropdown - looping statement normal or enhanced
        //Using normal for loop
       for (int i=0;i< drop_options.size();i++) {
            System.out.println(drop_options.get(i).getText()); }

        //Select options from dropdown
       /* for (int i=0;i<drop_options.size();i++) {
            String drop_option=drop_options.get(i).getText();

            if (drop_option.equals("India")) {
                drop_options.get(i).click();
                 }   // Seelect country, Brazil, China, France, India, USA
        }*/

        //using enhanced for loop, easier
        for (WebElement drop_option:drop_options) {
            String text=drop_option.getText();
            if (text.equals("Brazil")){
                drop_option.click();
                break;
            }
        }

        //clicking on the dropdown - states
        driver.findElement(By.xpath("//div[@class='frmDronpDown']/div/descendant::select[contains(@id,'state-list')]")).click();
        List<WebElement> drop_states= driver.findElements(By.xpath("//*[@id=\"state-list\"]/option"));

        //Find total number of options
        System.out.println("Total number of options:  "+drop_states.size()); //total 5

        //Print all the options from dropdown - looping statement normal or enhanced
        //Using normal for loop
        for (int i=0;i< drop_states.size();i++) {
            System.out.println(drop_states.get(i).getText()); }

        //Select options from dropdown
       /* for (int i=0;i<drop_options.size();i++) {
            String drop_option=drop_options.get(i).getText();

            if (drop_option.equals("India")) {
                drop_options.get(i).click();
                 }   // Select country, Brazil, China, France, India, USA
        }*/

        //using enhanced for loop, easier
        for (WebElement drop_state:drop_states) {
            String text=drop_state.getText();
            if (text.equals("Ceara")){
                drop_state.click();
            }
        }


    }
}
