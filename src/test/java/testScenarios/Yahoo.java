package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Yahoo {
	WebDriver driver;
	@Test(description="Launch Yahoo",priority=1)
	public void openYahoo()
	{
		System.out.println("Launch Yahoo");
		driver=new EdgeDriver();
		driver.get("https://www.yahoo.com/?guccounter=1");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();
		
	}
	
	//enabled = false , testng skips this method
	@Test(description="Login Yahoo-Hard Assert",priority=2,enabled=false)
	public void loginYahoo1() throws InterruptedException
	{
		System.out.println("Login Yahoo");
		//check title
		String act_title=driver.getTitle(); // gets the title from actual application
		System.out.println("title="+act_title);
		Assert.assertEquals(act_title, "login - Sign in to Yahoo"); //hard assert
		System.out.println("Assert executed...");
		driver.findElement(By.id("login-username")).sendKeys("jack");
		Thread.sleep(3000);
		
		
	}
	@Test(description="Login Yahoo-Soft Assert",priority=2)
	public void loginYahoo() throws InterruptedException
	{
		SoftAssert assertion = new SoftAssert();
		System.out.println("Login Yahoo");
		//check title
		String act_title=driver.getTitle(); // gets the title from actual application
		System.out.println("title="+act_title);
		assertion.assertEquals(act_title, "Login - Sign in to Yahoo"); //hard assert
		System.out.println("Assert executed...");
		driver.findElement(By.id("login-username")).sendKeys("jack");
		Thread.sleep(3000);
		assertion.assertAll(); //always call this method at the end of the test otherwise the failures wont be reported
		
		
		
	}
	@Test(description="Close Yahoo",priority=3)
	public void closeYahoo()
	{
		System.out.println("Close Yahoo");
		driver.quit();
		
	}

}