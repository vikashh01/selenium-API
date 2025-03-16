package newAss;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

public class HandleFrames {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.automationtesting.in/Frames.html");

      
            driver.switchTo().frame("SingleFrame");

            WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));
            inputField.sendKeys("Selenium Frame Test");

            takeScreenshot(driver, "single_frame.png"); 

            driver.switchTo().defaultContent(); 

            WebElement nestedTab = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
            nestedTab.click(); 

            WebElement outerFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
            driver.switchTo().frame(outerFrame); 

            WebElement innerFrame = driver.findElement(By.xpath("//iframe"));
            driver.switchTo().frame(innerFrame); 

            WebElement nestedInput = driver.findElement(By.xpath("//input[@type='text']"));
            nestedInput.sendKeys("Nested Frame Test");

            takeScreenshot(driver, "nested_frame.png"); 

            driver.switchTo().defaultContent(); 
        } 
    

    public static void takeScreenshot(WebDriver driver, String filename) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\path\\to\\" + filename));
        System.out.println("Screenshot saved: " + filename);
    }
}

