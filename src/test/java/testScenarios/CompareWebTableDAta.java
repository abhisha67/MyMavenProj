package testScenarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CompareWebTableDAta {

	ArrayList<String> exp_data=new ArrayList<String>();
	ArrayList<String> act_data=new ArrayList<String>();
	FileReader fr;
	BufferedReader br;
	String src="C:\\sel\\sel@9AM(EST)\\data.txt";	
	@Test(priority=1)
	public void readDataFrmTxt() throws IOException
	{
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		String cont=null;
		while ((cont=br.readLine())!=null)
		{
			exp_data.add(cont);
		}
		System.out.println("Expected Row Count="+exp_data.size());
		br.close();
	}
		@Test(priority=2)
		public void readDataFrmWT()
		{
			WebDriver driver=new EdgeDriver();
			driver.get("https://www.w3schools.com/html/html_tables.asp");
			driver.manage().window().maximize();
			WebElement myTable=driver.findElement(By.id("customers"));
			List<WebElement> allRows=myTable.findElements(By.tagName("tr"));
			System.out.println("total number of rows="+allRows.size());
			
			//nested for loop
			for(int i=1;i<allRows.size();i++)  //focus Row  i=2
			{
				List<WebElement> allCols=allRows.get(i).findElements(By.tagName("td"));
				for(int j=0;j<allCols.size();j++)  //focus column
				{
					//System.out.println(allCols.get(j).getText());
					act_data.add(allCols.get(j).getText());
					
				}
			}
			System.out.println("Actual Row Count="+exp_data.size());
			driver.quit();
		}
		@Test(priority=3)
		public void compare()
		{
			for(int i=0;i<exp_data.size();i++)
			{
				if(exp_data.get(i).equals(act_data.get(i)))
				{
					System.out.println("Item Matched..");
				}
				else
				{
					System.out.println("Item not Matched...");
				}
				
			}
	}
	
}
