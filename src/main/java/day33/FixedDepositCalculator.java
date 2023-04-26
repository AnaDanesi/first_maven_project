package day33;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;

public class FixedDepositCalculator {

    public static void main(String[] args) throws IOException, InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

        //login (not in the course)

        driver.switchTo().frame("myframe");
        WebElement username=driver.findElement(By.xpath("//div[@class='textfieldbox PR']//input[@id='email']"));
        username.sendKeys("pualani.concreto@gmail.com");

        WebElement password=driver.findElement(By.xpath("//div[@class='textfieldbox PR usepwd']//input[@id='pwd']"));
        password.sendKeys("Ana*123456");

        driver.findElement(By.xpath("//button[@id='ACCT_LOGIN_SUBMIT']")).click();

        //accept terms and conditions

        Thread.sleep(5000);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("myframe");

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[2]/ul[1]/li[1]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[2]/ul[1]/li[2]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[2]/ul[1]/li[3]/div[1]/input[1]")).click();

        driver.findElement(By.xpath("//div[@id='id_login']//button[@id='submit']")).click();

        driver.switchTo().defaultContent();

        //excel file
        String file = System.getProperty("user.dir") + "/testdata/caldata.xlsx";

        int rows = ExcelUtils.getRowCount(file, "Sheet1");


        for (int i = 1; i <= rows; i++) {
            //read data from excel
            String princ = ExcelUtils.getCellData(file, "Sheet1", i, 0);
            String rateofinterest = ExcelUtils.getCellData(file, "Sheet1", i, 1);
            String per1 = ExcelUtils.getCellData(file, "Sheet1", i, 2);
            String per2 = ExcelUtils.getCellData(file, "Sheet1", i, 3);
            String fre = ExcelUtils.getCellData(file, "Sheet1", i, 4);
            String exp_mvalue = ExcelUtils.getCellData(file, "Sheet1", i, 5);


            //pass data to the app
            driver.findElement(By.id("principal")).sendKeys(princ);
            driver.findElement(By.id("interest")).sendKeys(rateofinterest);
            driver.findElement(By.id("tenure")).sendKeys(per1);

            Select perdrp = new Select(driver.findElement(By.id("tenurePeriod")));
            perdrp.selectByVisibleText(per2);

            Select fredrp = new Select(driver.findElement(By.id("frequency")));
            fredrp.selectByVisibleText(fre);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement calculate_btn = driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
            js.executeScript("arguments[0].click();", calculate_btn);  // clicking on calculate button

            //validation & update results in excel
            String act_mvalue = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();

            if (Double.parseDouble(exp_mvalue) == Double.parseDouble(act_mvalue)) {
                System.out.println("Test Passsed");
                ExcelUtils.setCellData(file, "Sheet1", i, 7, "Passed");
                ExcelUtils.fillGreenColor(file, "Sheet1", i, 7);
            } else {
                System.out.println("Test Failed");
                ExcelUtils.setCellData(file, "Sheet1", i, 7, "Failed");
                ExcelUtils.fillRedColor(file, "Sheet1", i, 7);
            }
            Thread.sleep(3000);

            WebElement clear_btn = driver.findElement(By.xpath("//img[@class='PL5']"));
            js.executeScript("arguments[0].click();", clear_btn);  // clicking on clear button


        }
    }
}
