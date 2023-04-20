package day31;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CaptureScreenshot {

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //Capture full page screenshot - selenium 3 & 4
		/*TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("/home/anita/workspace/seleniumproject/screenshot/fullpage.png");
		FileUtils.copyFile(src, trg);

        // capture screenshot of specific area from webpage -- selenium 4+

		WebElement featuredproducts=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));

		File src=featuredproducts.getScreenshotAs(OutputType.FILE);
		File trg=new File("/home/anita/workspace/seleniumproject/screenshot/featureproducts.png");
		FileUtils.copyFile(src, trg);
		*/

        // capture screenshot of specific Web element -- selenium 4+

        WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));

        File src=logo.getScreenshotAs(OutputType.FILE);
        File trg=new File("/home/anita/workspace/seleniumproject/screenshot/logo.png");
        FileUtils.copyFile(src, trg);

    }
}
