package Homework.week4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundTable {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		WebElement table = driver.findElement(By.id("table_id"));
		List<WebElement> colCount = driver.findElements(By.tagName("th"));
		System.out.println("Number of columns in this table is" + " " + colCount.size());

		List<WebElement> rowCount = driver.findElements(By.tagName("tr"));
		System.out.println("Number of columns in this table is" + " " + rowCount.size());
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//input[@name='vital'])[3]")).click();
		String text = driver.findElement(By.xpath("(//tr[@class='even'])[1]/td[2]")).getText();
		System.out.println("Progress value of Learn to interact with elements" + " " + text);
		List<WebElement> row = table.findElements(By.tagName("tr"));
		
		
		
		
	}
}

