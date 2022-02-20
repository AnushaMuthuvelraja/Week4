package Homework.week4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrames {

	public static void main(String[] args)
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@id='Click']")).click();
        driver.switchTo().defaultContent();//switched to parent frame
		
        driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//button[@id='Click1']")).click();
		driver.switchTo().defaultContent();
		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		int size = totalFrames.size();
		System.out.println("Total no of Frames=" + " " + size );
		//System.out.println(size);
	}

}
