package Homework.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundSortinginTables {
static String sort;
	public static void main(String[] args)
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table_id']//tr/td[2]"));
		
		String[] beforeSort = new String[cols.size()];
				for(int i=0;i<cols.size();i++)
				{
					beforeSort[i]=cols.get(i).getText().trim();
					System.out.println(beforeSort[i]);
					
				}
				
				System.out.println("sorting value using sort method");
				System.out.println("------------------------------");	
				
				
				
				for(int i=0;i<cols.size();i++)
				{
					Arrays.sort(beforeSort);
					sort=beforeSort[i];
					System.out.println(sort);
				}
		
				driver.findElement(By.xpath("//th[text()='Name']")).click();
				cols = driver.findElements(By.xpath("//table[@id='table_id']//tr/td[2]"));
				String[] afterSort = new String[cols.size()];
				System.out.println("Sorting values after comparing");
				System.out.println("____________________________________________________________");
						for(int i=0;i<cols.size();i++)
						{
							afterSort[i]=cols.get(i).getText().trim();
							System.out.println(afterSort[i]);
							
						}
						
						Assert.assertEquals(beforeSort, afterSort);
						
	}
}



