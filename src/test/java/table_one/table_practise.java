package table_one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class table_practise {
    WebDriver driver;
    @BeforeMethod
    public void createwebdriver(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice/");
    }

    @Test
    public void table_element_identify(){

        WebElement url_click=driver.findElement(By.linkText("Test Table"));
        url_click.click();

        //row count
        int rows=driver.findElements(By.xpath("//table[@id='courses_table']/tbody//tr")).size();
        System.out.println(rows);

        //column count
        int columns=driver.findElements(By.xpath("//table[@id='courses_table']/thead//tr//th")).size();
        System.out.println(columns);

        //one column
        String data=driver.findElement(By.xpath("//table[@id='courses_table']/tbody//tr[1]/td[1]")).getText();
        System.out.println(data);

        //tr= table row
        //td=table data[cell]

        //print datable all data
        for(int i=1;i<=rows;i++){
            for(int j=1;j<columns;j++){
                String dataa=driver.findElement(By.xpath("//table[@id='courses_table']/tbody//tr["+i+"]/td["+j+"]")).getText();
                System.out.println(dataa +'\t');
            }
            System.out.println();
        }



    }
    @Test
    public void click_spesific_item(){
        int row_count=driver.findElements(By.xpath("//table[@id='courses_table']/tbody//tr")).size();
        for(int i=1;i<=row_count;i++){
            String course_name=driver.findElement(By.xpath("//table[@id='courses_table']/tbody/tr["+i+"]/td[2]")).getText();
            if(course_name.equals("Selenium with Python")){
                WebElement link=driver.findElement(By.xpath("//table[@id='courses_table']/tbody/tr[8]/td[6]/a"));
                link.click();
                break;
            }
        }
    }

    //filterinng radio button
    @Test
    public void filtering(){
        //radio button eka click karanawa
        WebElement radio_button=driver.findElement(By.xpath("//input[@name='lang' and @value='Java'"));
        if(!radio_button.isSelected()){
            Select obj=new Select(radio_button);
            obj.selectByVisibleText("java");
        }
        //rows gaana count karanawa
        int rows_number=driver.findElements(By.xpath("//table[@id='courses_table']/tbody//tr")).size();

        //hama row ekakma check karanawa
        for(int i=1;i<=rows_number;i++){
            String text=driver.findElement(By.xpath("//table[@id='courses_table']/tbody/tr["+i+"]/td[3]")).getText();
            System.out.println(text);
            if(text.equals("java")){
                System.out.println("row"+i+"pass");
            }else{
                System.out.println("rows"+i+"fail");
            }

        }

    }
    //filtering checkbox
    @Test
    public void filtering_two(){
        WebElement intermidiate_box=driver.findElement(By.xpath("//input[@name='level' and @value='Intermediate']"));
        if(!intermidiate_box.isSelected()){
            intermidiate_box.click();
        }
        WebElement beginer_box=driver.findElement(By.xpath("//input[@name='level' and @value='Beginner']"));
        if(beginer_box.isSelected()){
            beginer_box.click();
        }
        WebElement advance_box=driver.findElement(By.xpath("//input[@name='level' and @value='Advanced']"));
        if(advance_box.isSelected()){
            advance_box.click();
        }

        String value=driver.findElement(By.xpath("//input[@name='level' and @value='Intermediate']")).getAttribute("value");
        int row_count=driver.findElements(By.xpath("//table[@id='courses_table']/tbody//tr")).size();

        for(int i=1;i<=row_count;i++){
            String select=driver.findElement(By.xpath("//table[@id='courses_table']/tbody/tr["+i+"]/td[4]")).getText();
            if(select.equals(value)){
                System.out.println("rows"+i+"pass");
            }else{
                System.out.println("rows "+i+"fail");
            }
        }

    }

    @Test
    public void sorting_by_dropdown(){
        WebElement dropdown=driver.findElement(By.id("sortBy"));
        Select select_obj=new Select(dropdown);
        select_obj.selectByVisibleText("ID");

        int row_count=driver.findElements(By.xpath("//table[@id='courses_table']/tbody//tr")).size();
        List<Integer> actual_value_list=new ArrayList<>();

        for(int i=1;i<=row_count;i++){
            String id=driver.findElement(By.xpath("//table[@id='courses_table']/tbody/tr["+i+"]/td[1]")).getText();
            actual_value_list.add(Integer.parseInt(id));

        }
        List<Integer> expected_list=new ArrayList<>();
        Collections.sort(expected_list);
        Assert.assertEquals(actual_value_list,expected_list);


    }



}
