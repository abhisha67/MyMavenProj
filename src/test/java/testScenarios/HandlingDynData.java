package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingDynData {
	
	@Test
	public void dynData() throws InterruptedException
		{
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
			driver.manage().window().maximize();
			for(int i=1;i<=4;i++);
			{
			String str=driver.findElement(By.id("ebcaptchatext")).getText();
			System.out.println(str);
			String str1=str.substring(8, 9);
			String str2=str.substring(12, 13);
			System.out.println(str1+"\t"+str2);
			Integer res=Integer.valueOf(str1)+Integer.valueOf(str2);
			System.out.println(res);
			driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(res));
			boolean chkBtn=driver.findElement(By.xpath("//*[@id=\"form\"]/input[2]")).isEnabled();
			if(chkBtn==true)
			{
				System.out.println("Calculation is correct ...");
			}
			else
			{
				System.out.println("Calculation is incorrect...");
			}
			driver.navigate().refresh();
			Thread.sleep(5000);
			}
			driver.quit();
		}
	}
	
