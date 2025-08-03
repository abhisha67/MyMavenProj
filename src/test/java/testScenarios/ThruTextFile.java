package testScenarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class ThruTextFile {
	File fc;
	FileWriter fw;
	BufferedWriter bw;
	FileReader fr;
	BufferedReader br;
	String src="C:\\sel\\sel@9AM(EST)\\data.txt";
	@Test
	public void writeAndreadData() throws IOException
	{
		fc=new File(src);
		fc.createNewFile();
		fw=new FileWriter(src);
		bw=new BufferedWriter(fw);
		bw.write("This is my First Line");
		bw.newLine();
		bw.write("This is my Second Line");
		bw.newLine();
		bw.write("This is my Third Line");
		bw.close();
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		String cont=null;
		while((cont=br.readLine())!=null)
		{
			System.out.println(cont);
		}
		br.close();
		
	}
	
}
