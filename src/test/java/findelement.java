import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class findelement {
    @Test
    public void find_element(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement textbox=driver.findElement(By.name("q"));
        textbox.sendKeys("god"+ Keys.ENTER);
        driver.quit();


    }
}
