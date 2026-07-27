import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class links {
    WebDriver driver; //meka reference variable ekak
    //webdriver kiyana interface ekata hadana reference variable ekak

    @BeforeMethod
    public void openlinktest(){
        driver=new ChromeDriver(); //driver=new (object ekak hadanawa) me object eka uda reference variable eke store karanawa
        //uda hadapu reference variable eka global variable ekak hinda apita one thanaka use karanna puluwan
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice/");
    }
    @Test
    public void testlinks() throws InterruptedException {
        WebElement links=driver.findElement(By.xpath("//a[text()='Test Login Page']"));
        Thread.sleep(3000);
        links.click();
        Thread.sleep(3000);

    }
    @Test
    public void testlink2_identift () throws InterruptedException {
        WebElement link2=driver.findElement(By.linkText("Test Login Page")); //link ekak identify karaganna lesima kramaya meka
        //linktext use karanawa (link eke apita pena text eka)
        Thread.sleep(3000);
        link2.click();
        Thread.sleep(3000);
        driver.navigate().back(); //apahu back wenna
        Thread.sleep(3000);


        String path=link2.getAttribute("href"); //html elemet ekak attribute value eka ganna
        System.out.println("link goto "+path);
        Thread.sleep(3000);


        String title=driver.getTitle(); // title eka ganne mehemai
        if(title.contains("404")){
            System.out.println("link is broken");
        }else{
            System.out.println("link is work");
        }
        Thread.sleep(3000);
        System.out.println(title);

        driver.navigate().back();
        System.out.println(title);
        Thread.sleep(3000);
        List<WebElement> countlink=driver.findElements(By.tagName("a"));
        int pagelink=countlink.size();
        System.out.println(pagelink);
        System.out.println(title);







    }
    @Test
    public void test_link2(){
        String title=driver.getTitle();
        WebElement element_link=driver.findElement(By.linkText("Test Login Page"));
        System.out.println("before clicking title "+title);

        element_link.click();


        System.out.println("title is "+title);

    }



}
