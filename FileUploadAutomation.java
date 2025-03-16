package newAss;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadAutomation {
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();

  
            driver.get("https://the-internet.herokuapp.com/upload");

            WebElement fileInput = driver.findElement(By.xpath("//input[@id='file-upload']"));

            String filePath = "C:\\\\Users\\\\AKASH KUMAR BHARTI\\\\Downloads\\\\pic.jpg";
            fileInput.sendKeys(filePath);

            WebElement uploadButton = driver.findElement(By.xpath("//input[@id='file-submit']"));
            uploadButton.click();

           
    }
}
