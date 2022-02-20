package Homework.week4;

import java.awt.Dimension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;

public class Resizable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.switchTo().frame(0);
		WebElement resize = driver.findElement(By.id("resizable"));
		Actions action=new Actions(driver);
		action.clickAndHold(resize).moveByOffset(100, 100).release().perform();

	}

}
