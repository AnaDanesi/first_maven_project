package day21YouTube;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XPathAxesDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
        driver.manage().window().maximize();

        //Self  - Selects the current node
        String text=driver.findElement(By.xpath("//a[normalize-space()='Data Patterns (India']/self::a")).getText();
        System.out.println(text); //Data Patterns (India

        //Parent - Selects the parent of the current node (always One)
        text= driver.findElement(By.xpath("//a[normalize-space()='Data Patterns (India']/parent::td")).getText();
        System.out.println(text); //Data Patterns (India

        //Child - Selects all children of the current node (One or many) (actually our self node doesnt have a child, so we use the ancestor to go down
        List<WebElement> childs=driver.findElements(By.xpath("//a[normalize-space()='Data Patterns (India']/ancestor::tr/child::td"));
        System.out.println("Number of child element:  "+ childs.size()); //Number of child element : 5

        //Ancestor - Selects all ancestors (parent, grandparent, etc.)
        text=driver.findElement(By.xpath("//a[normalize-space()='Data Patterns (India']/ancestor::tr")).getText();
        System.out.println(text); //Data Patterns (India A 1,350.20 1,417.00 + 4.95 (it brings all the data of the row because it doesnt have any text

        //Descendant - Selects all descendants (children, grandchildren, etc.) of the current node (child and grandchild if we put * 7 elements, if we put td 5 elements)
        List<WebElement> descendants=driver.findElements(By.xpath("//a[normalize-space()='Data Patterns (India']/ancestor::tr/descendant::*"));
        System.out.println("Number of descendants:  "+descendants.size()); //7 elements

        //Following -Selects everything in the document after the closing tag of the current node
        List<WebElement>followingnodes=driver.findElements(By.xpath("//a[normalize-space()='Data Patterns (India']/ancestor::tr/following::tr"));
        System.out.println("Number of following nodes:"+followingnodes.size()); //151 elements

        //Following-sibling : Selects all siblings after the current node
        List<WebElement> followingsiblings=driver.findElements(By.xpath("//a[normalize-space()='Data Patterns (India']/ancestor::tr/following-sibling::tr"));
        System.out.println("Number of Following Siblings:"+followingsiblings.size()); //149 elements

        //Preceding - Selects all nodes that appear before the current node in the document
        List<WebElement> precedings=driver.findElements(By.xpath("//a[normalize-space()='Data Patterns (India']/ancestor::tr/preceding::tr"));
        System.out.println("Number of preceding nodes:"+precedings.size()); //6 elements

        //preceding-sibling - Selects all siblings before the current node
        List<WebElement> precedingsiblings=driver.findElements(By.xpath("//a[normalize-space()='Data Patterns (India']/ancestor::tr/preceding-sibling::tr"));
        System.out.println("Number of preceding sibling nodes:"+precedingsiblings.size()); //5 elements


        driver.close();

    }
}
