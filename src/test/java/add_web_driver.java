import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class add_web_driver {

@Test
    public void createdriver(){
    WebDriver driver=new ChromeDriver();
    driver.get("https://www.google.com/");
    driver.quit();

}
}
