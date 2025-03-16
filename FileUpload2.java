package newAss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload2 {
    public static void main(String[] args) {
       
        WebDriver driver = new ChromeDriver();

        
            driver.get("https://the-internet.herokuapp.com/upload");

            WebElement fileInput = driver.findElement(By.xpath("//input[@id='file-upload']"));

            String filePath = "C:\\Users\\AKASH KUMAR BHARTI\\Downloads\\pic.jpg";
            fileInput.sendKeys(filePath);

            WebElement uploadButton = driver.findElement(By.xpath("//input[@id='file-submit']"));
            uploadButton.click();

            WebElement successMessage = driver.findElement(By.tagName("h3"));
            System.out.println("Success Message: " + successMessage.getText());

            WebElement uploadedFileName = driver.findElement(By.id("uploaded-files"));
            System.out.println("Uploaded File Name: " + uploadedFileName.getText());

            if (uploadedFileName.getText().equals("file.txt")) {
                System.out.println("File uploaded successfully!");
            } else {
                System.out.println("File upload verification failed.");
            }
        } 
}

