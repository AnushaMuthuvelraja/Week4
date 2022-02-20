package Homework.week4;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disappear {

	public static void main(String[] args)
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/disapper.html");

		WebElement findElement = driver.findElement(By.xpath("//button[@id='btn']/b"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(findElement));        
		String text = driver.findElement(By.xpath("//div[@id='show']")).getText();
		//System.out.println(text);
		if(text.contains("I know you can do it! Button is disappeared!"))
		{
			System.out.println(text + "is appeared after wait");
		}
		else
		{
			System.out.println(text + " is not appeared after wait");
		}
	}

}
