package day29;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/*
slider --- dragAndDropBy(Element, x,y);
 */

public class SliderDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        Actions act=new Actions(driver);

        //Min slider
        WebElement min_slider=driver.findElement(By.xpath("//span[1]"));
        System.out.println("Current location of min slider:"+min_slider.getLocation());  //(59, 250) x,y
        act.dragAndDropBy(min_slider, 100, 250).perform();
        System.out.println("Location of min slider After moving:"+min_slider.getLocation());  //tendriamos que obtener 159+-3 /161 esta ok, depende de la resolucion de la pantalla

        //Max slider
        WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
        System.out.println("Current location of max slider:"+max_slider.getLocation()); //(737, 250)

        act.dragAndDropBy(max_slider, -37, 250).perform();
        System.out.println("Location of max slider after moving:"+max_slider.getLocation()); // deberia dar 700+-3 , dio 696 esta ok
    }

}
