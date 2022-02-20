package Homework.week4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {

	public static void main(String[] args)
	{
		
				


	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/pages/TextChange.html");
	
	WebElement OnClick= driver.findElement(By.xpath("//button[@class='btn']"));
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.textToBePresentInElement(OnClick,"Click ME!"));
    OnClick.click();
    
    Alert alert = driver.switchTo().alert();
    String text = alert.getText();
    System.out.println(text);
    alert.accept();
}


}

	
	
	
	
	
	
	