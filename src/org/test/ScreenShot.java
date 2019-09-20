package org.test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAJESH\\Desktop\\Chandru\\eclipse\\f\\ScreenShotSnap\\driver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.snapdeal.com/");
		
		WebElement findElement = driver.findElement(By.id("inputValEnter"));
		
		findElement.sendKeys("shoes men wear");
		driver.findElement(By.xpath("//span[@class='searchTextSpan']")).click();
		WebElement findElement2 = driver.findElement(By.xpath("//p[text()='jebsroo wear Sneakers Gray Casual Shoes']"));
		findElement2.click();
		
		String par=driver.getWindowHandle();
		Set<String>  all=driver.getWindowHandles();
		System.out.println(par);
		System.out.println(all);
		for (String x : all) {
			
			if(!par.equals(x))
			{
				driver.switchTo().window(x);
				
				
			}
		}

		driver.findElement(By.xpath("//span[text()='add to cart']")).click();
		//driver.findElement(By.xpath("//span[text()='add to cart']")).click();
		driver.findElement(By.xpath("//div[text()='View Cart']")).click();
		
		TakesScreenshot sc=(TakesScreenshot)driver;
		File src=sc.getScreenshotAs(OutputType.FILE);
		File dsc=new File("C:\\Users\\RAJESH\\Desktop\\Chandru\\eclipse\\f\\ScreenShotSnap\\Screenshot\\Sample.png");
		
		
		FileUtils.copyFile(src, dsc);
		System.out.println("Screenshot done");
	}


	}

