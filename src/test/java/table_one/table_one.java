package table_one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class table_one {
    WebDriver driver;
    @BeforeMethod
    public void createdriver(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }
    @Test
    public void how_many_rows() throws InterruptedException {
        //table eke row count eka
        ////table[@id='productTable']/tbody//tr
        int row=driver.findElements(By.xpath("//table[@id='productTable']/tbody//tr")).size();
        System.out.println("row count is "+row);

        //table eke column gaana
        //thead ekata giya
        //eke tr eke th ewa
        int column_count=driver.findElements(By.xpath("//table[@id='productTable']/thead/tr//th")).size();
        System.out.println("column count is "+column_count);

        //get values of cell
        ////*[@id="productTable"]/tbody/tr[3]/td[3]
        String value=driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println(value);

        //values read
        //outerloop = row count
        //innerloop = data read

        for(int i=1;i<=row;i++){ //row
            for(int j=1;j<column_count;j++){ //columns
               String dataa= driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(dataa);

            }
            System.out.println();
        }

        //print id and name
        for(int i=1;i<=row;i++){
            String id= driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
            String name= driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println("id is "+id+ "name is "+name);

            if(name.equals("Tablet")){
                String prname=driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();
                System.out.println(prname);

            }


        }

        //select all pages selector box
        int number_of_pages=driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pages=driver.findElements(By.xpath("//ul[@id='pagination']/li"));
        for(int k=0;k<number_of_pages;k++){
            pages.get(k).click();
            Thread.sleep(300);
            for(int i=1;i<=number_of_pages;i++){
                boolean attribute=driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).isSelected();
                if(!attribute){
                    driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).click();
                    Thread.sleep(300);
                }
            }
        }







    }
}
