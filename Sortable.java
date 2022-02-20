package Homework.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args)
	{
	   
	/*	WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/sortable/");
        driver.manage().window().maximize();
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='sortable']/li"));
		
		WebElement from= elements.get(6);
		WebElement to = elements.get(0);
		
		Actions act=new Actions(driver);
		act.clickAndHold(from).moveToElement(to).release(to).perform();
	}*/
	
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration 20);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.switchTo().frame(0);
        
        WebElement ele1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
        WebElement ele2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
        WebElement ele3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
        WebElement ele4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
        WebElement ele5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
        WebElement ele6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
        WebElement ele7 = driver.findElement(By.xpath("//li[text()='Item 7']"));
        
        Actions actions = new Actions(driver);
        actions.dragAndDrop(ele2 , ele1).perform();
        actions.dragAndDrop(ele4, ele3).perform();
        actions.dragAndDrop(ele6, ele5).perform();
	}

	}
