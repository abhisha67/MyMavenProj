package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {
	
	@Test
	public void dragAndDrop() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/droppable/");
	driver.manage().window().maximize();
	driver.switchTo().frame(0);
	WebElement drag=driver.findElement(By.id("draggable"));
	WebElement drop=driver.findElement(By.id("droppable"));
	Actions action=new Actions(driver);
	//action.dragAndDrop(drag, drop).build().perform();
			action.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
			Thread.sleep(4000);
			driver.quit();
	}
	@Test
	public void dataPicker()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		Integer exp_year=2026;
		String exp_month="January";
		driver.findElement(By.id("datepicker")).click();
		while(true)
		{
			String act_month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
			String act_year=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();
			System.out.println(act_month+"\t"+act_year);
			if(act_year.equals(String.valueOf(exp_year)) && act_month.equals(exp_month))
			{
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[5]/a")).click();
				break;
			}
			if(exp_year<=2025)  //2026<=2025
			{
				//click on previous button
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			}
			else
			{
				//click on next button
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			}
			
		}
		
		driver.quit();
	}
	
}
