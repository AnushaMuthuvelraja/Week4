package Homework.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[1]")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Merge Contacts")).click();//click Merge
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();//from
		Set<String> windowHandles = driver.getWindowHandles();//new window
		List<String> l=new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));//new window
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();//first resulting
		driver.switchTo().window(l.get(0));//oldwindow
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();//to
		Set<String> windowHandles1 = driver.getWindowHandles();//new window
		List<String> l1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(l1.get(1));//new window
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();//second resulting
		driver.switchTo().window(l.get(0));//old window
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();//merge
		Thread.sleep(2000);

		Alert alert=driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		String currentUrl = driver.getCurrentUrl();  
		System.out.println(currentUrl);
		if(currentUrl.contains("viewcontact"))
		{
			System.out.println("Verified");
		}

	}

}
