package Homework.week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();  

		driver.get("https://www.amazon.in/");

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		//Thread.sleep(2000);
		String FirstProductPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Price of first product:=" +FirstProductPrice);

		Thread.sleep(2000);


		String text = driver.findElement(By.xpath("(//i[contains(@class,'a-icon a-icon-star-small')]/following::span)[2]")).getText();

		//String text = driver.findElement(By.xpath("(//a[@role='button']//i)[2]")).getText();
		System.out.println("Number of customer ratings for the first product:=" +text);

		Thread.sleep(2000);


		driver.findElement(By.xpath("//i[contains(@class,'a-icon a-icon-star-small')]")).click();


		Thread.sleep(2000);
		String attribute = driver.findElement(By.xpath("//a[@class='a-link-normal 5star']")).getAttribute("title");

		System.out.println(attribute);


		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		File source=driver.getScreenshotAs(OutputType.FILE);
		File dest= new File("./src/main/resources/snapshot/Img001.png");
		FileUtils.copyFile(source, dest);
		Set<String> windowHandles = driver.getWindowHandles();//new window
		List<String> l=new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));//new window
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);


		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(5000);

		String  text2= driver.findElement(By.xpath("(//span[@id='attach-accessory-cart-subtotal'])[1]")).getText();
		System.out.println("Total amount in cart : " + text2);
		if(text2.contains(FirstProductPrice))
		{
			System.out.println(text2 + " - Cart Value is correct" );
		}

	}


}
