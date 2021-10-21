package Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	@Test (priority=5)

	public void negativeLogin() throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		driver.get("http://magento.com");
		Thread.sleep(1000);
		driver.findElement(By.id("gnav_565")).click();
		
		driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("welcome");
		driver.findElement(By.name("send")).click();

		Thread.sleep(3000);
		String Error= driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
		
		System.out.println(Error);	
	    AssertJUnit.assertEquals(Error, "Invalid login or password.");
		
		
	}
	
	@Test (priority=10 ,enabled=true)
public void positiveLogin() throws InterruptedException
{
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
	driver.get("http://magento.com");
	Thread.sleep(1000);
	driver.findElement(By.id("gnav_565")).click();
	
	driver.findElement(By.id("email")).sendKeys("test@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("welcome@123");
	driver.findElement(By.name("send")).click();

	Thread.sleep(3000);
	
	
}
}

