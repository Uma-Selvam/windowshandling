package Commoncode;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowshandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\eclipse-workspace\\Bddcucumber\\src\\test\\resources\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demoqa.com/");
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1100)");
		driver.findElement(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Browser Windows')]")).click();
		Thread.sleep(3000);
		
		//windows handling
		
		
		
		String parentwindow=driver.getWindowHandle();
		System.out.println("parentid is"+parentwindow);
		
		//childwindow
		driver.findElement(By.id("tabButton")).click();
		Thread.sleep(3000);
		Set<String>childwindow=driver.getWindowHandles();
		for(String allwindow:childwindow)
		{
			if(!allwindow.equals(parentwindow))
			{
				driver.switchTo().window(allwindow).close();;
				
			}
			System.out.println("child id"+allwindow);
			
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			WebElement sendowindow=driver.findElement(By.id("windowButton"));
			sendowindow.click();
			System.out.println("id"+sendowindow);
			Set<String>current=driver.getWindowHandles();
			for(String l:current)
			{
				if(!current.equals(current))
				{
					driver.switchTo().window(allwindow);
				}
			}
			
			
			
			
			
			
		}
		
		
		
		//driver.close();
		
	}
	

}
