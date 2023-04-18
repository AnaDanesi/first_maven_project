package day29;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();

        Actions act=new Actions(driver);

        // Rome---> Italy
        WebElement rome=driver.findElement(By.xpath("//div[@id='box6']"));
        WebElement italy=driver.findElement(By.xpath("//div[@id='box106']"));

        act.dragAndDrop(rome, italy).perform(); // drag and drop

        // Washington---> USA
        WebElement washington=driver.findElement(By.xpath("//div[@id='box3']"));
        WebElement usa=driver.findElement(By.xpath("//div[@id='box103']"));

        act.dragAndDrop(washington, usa).perform();

        // Copenhagen ---> Denmark
        WebElement copen=driver.findElement(By.xpath("//div[@id='box4']"));
        WebElement denmark=driver.findElement(By.xpath("//div[@id='box104']"));

        act.dragAndDrop(copen, denmark).perform();

        // Seoul ---> South Korea
        WebElement seoul=driver.findElement(By.xpath("//div[@id='box5']"));
        WebElement sk=driver.findElement(By.xpath("//div[@id='box105']"));

        act.dragAndDrop(seoul, sk).perform();

        // Madrid ---> Spain
        WebElement madrid=driver.findElement(By.xpath("//div[@id='box7']"));
        WebElement spain=driver.findElement(By.xpath("//div[@id='box107']"));

        act.dragAndDrop(madrid, spain).perform();

        // Oslo ---> Norway
        WebElement oslo=driver.findElement(By.xpath("//div[@id='box1']"));
        WebElement norway=driver.findElement(By.xpath("//div[@id='box101']"));

        act.dragAndDrop(oslo, norway).perform();

        // Stockholm ---> Sweden
        WebElement stock=driver.findElement(By.xpath("//div[@id='box2']"));
        WebElement sweden=driver.findElement(By.xpath("//div[@id='box102']"));

        act.dragAndDrop(stock, sweden).perform();



    }

}
