package newAss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {

        Object[][] credentials = ExcelUtils.getExcelData("C:\\Users\\AKASH KUMAR BHARTI\\Downloads\\name (1).xlsx");

        for (Object[] user : credentials) {
            String username = user[0].toString();
            String password = user[1].toString();

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

               driver.get("https://practicetestautomation.com/practice-test-login/");

                WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
                WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));

                usernameField.sendKeys(username);
                passwordField.sendKeys(password);

                driver.findElement(By.xpath("//button[@id='submit']")).click();

                WebElement successMessage = driver.findElement(By.xpath("//h1[contains(text(),'Logged In Successfully')]"));
                if (successMessage.isDisplayed()) {
                    System.out.println("Login successful for user: " + username);
                } else {
                    System.out.println("Login failed for user: " + username);
                }

            } 
        }
    }


