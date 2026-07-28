package table_one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class professional_use_table {
    //"//table[@id='courses_table']/tbody//tr[1]/td[1]"

    WebDriver driver;
    @BeforeMethod
    public void createdriver(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice/");
    }
    @Test
    public String professional_print_data(int column,int row){
        String xpath="//table[@id='courses_table']/tbody//tr["+row+"]/td["+column+"]";
        return driver.findElement(By.xpath(xpath)).getText();
    }



}
