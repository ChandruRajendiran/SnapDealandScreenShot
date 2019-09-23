package org.austrian;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Home {
	@Parameters({"userName","password"})
	
	@Test
	private void login(String s1, String s2) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAJESH\\Desktop\\Chandru\\eclipse\\f\\AustrianAirline\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor sc=(JavascriptExecutor)driver;
		driver.get("https://m.austrian.com/#home/start");
		WebElement img = driver.findElement(By.xpath("//img[@src='img/LoggedOut.png']"));
		sc.executeScript("arguments[0].click();", img);
		//img.click();
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		WebElement txtuser = driver.findElement(By.xpath("//label[text()='Username or email address*']"));
txtuser.sendKeys(s1);
WebElement txtpass = driver.findElement(By.xpath("//label[text()='Password*']"));
txtpass.sendKeys(s2);
driver.findElement(By.xpath("//button[text()='Login']")).click();
	
	}
	

}
