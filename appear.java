package Homework.week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class appear {

	public static void main(String[] args) 
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/appear.html");

		WebElement findElement = driver.findElement(By.xpath("//button[@id='btn']/b"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findElement));
		String text = findElement.getText();
		if(text.equals("Voila! I'm here Guys"))

		{
			System.out.println(text+ " " + "it appeared after few seconds");
		}

		else
		{
			System.out.println(text + " " + "not appeared");

		}
	}

}
