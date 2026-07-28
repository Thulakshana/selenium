import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class with_waits {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void createwebdriver(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }
    @Test
    public void test_loading_element() throws InterruptedException {
        WebElement base_url=driver.findElement(By.linkText("Test Exceptions"));
        base_url.click();
        Thread.sleep(3000);

        WebElement add_button=driver.findElement(By.id("add_btn"));
        add_button.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement input=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']//input")));
        if(input.isDisplayed()){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }


    }
   @Test
    public void test_save() throws InterruptedException {
        WebElement url=driver.findElement(By.linkText("Test Exceptions"));
        url.click();
        Thread.sleep(3000);

        WebElement add_btn=driver.findElement(By.id("add_btn"));
        add_btn.click();

        WebDriverWait waits=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement input_two=waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='row2']//input")));

        input_two.sendKeys("apple");
        WebElement save_btn=driver.findElement(By.id("save_btn"));
        save_btn.click();

        WebElement messages=driver.findElement(By.id("confirmation"));
        if(messages.getText().contains("Row 2 was saved")){
            System.out.println("added");
        }else{
            System.out.println("not added");
        }

        WebElement edit_btn=waits.until(ExpectedConditions.elementToBeClickable(By.id("edit_btn")));
        edit_btn.click();

        input_two=waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='row2']//input")));
        input_two.clear();

        input_two.sendKeys("banana");
        save_btn.click();

       if(messages.getText().contains("Row 2 was saved")){
           System.out.println("updated");
       }else{
           System.out.println("not updated");
       }




    }
}
