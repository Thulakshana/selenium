import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class textbox {
    WebDriver driver;
    @BeforeMethod
    public void getpage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice/");
    }

    @Test
    public void testing_one() throws InterruptedException {
        WebElement link=driver.findElement(By.linkText("Test Login Page"));
        link.click();
        Thread.sleep(3000);

        WebElement username_textbox=driver.findElement(By.id("username"));
        username_textbox.sendKeys("student");
        WebElement password_textbox=driver.findElement(By.id("password"));
        password_textbox.sendKeys("Password123");
        Thread.sleep(3000);

        WebElement submit_button=driver.findElement(By.id("submit"));
        submit_button.click();
        Thread.sleep(3000);

        String actualurl=driver.getCurrentUrl();
        if(actualurl.contains("practicetestautomation.com/logged-in-successfully/")){
            System.out.println("logged sussefully");
        }else{
            System.out.println("not logged");
        }



    }
   //error
    @Test
    public void error_check() throws InterruptedException {
        WebElement url=driver.findElement(By.linkText("Test Login Page"));
        url.click();
        Thread.sleep(3000);

        WebElement username_textbox=driver.findElement(By.id("username"));
        username_textbox.sendKeys("student");
        WebElement password_textbox=driver.findElement(By.id("password"));
        password_textbox.sendKeys("apple");
        Thread.sleep(3000);

        WebElement submit_button=driver.findElement(By.id("submit"));
        submit_button.click();

        Thread.sleep(3000);

        WebElement message_box=driver.findElement(By.id("error")); //meaasge box ekak display wena text eka
        String msg= message_box.getText();
        System.out.println("message is " +msg);



    }
}
