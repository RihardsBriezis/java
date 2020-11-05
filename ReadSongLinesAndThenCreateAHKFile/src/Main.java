import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	static ArrayList<String> lyrics = new ArrayList<String>();
	static ArrayList<String> hk = new ArrayList<String>();
	public static void main(String[] args) 
	{
		String filePath = "lyrics.txt";
		readFiles(filePath);
		
		String hotkey;
		
		int count = 1;
		int key = 1;
		for(String text : lyrics)
		{
			if(count == 1)
			{
				hk.add("#InstallKeybdHook");
				hk.add("#UseHook");
			}
			if(count == 10)
			{
					hotkey = "^0::";
			}else {
					hotkey = "^"+count+"::";
			}
			hk.add(hotkey);
			String line = "Send {enter}/all "+text+" ("+count+"){enter}";
			hk.add(line);
			if(count == 10)
			{
				int runkey = key+1;
				String run = "Run "+runkey+".ahk";
				hk.add(run);
				hk.add("Exitapp");
				hk.add("return");
			}else {
				hk.add("return");
			}
			if(count == 10)
			{
				String writeName = String.valueOf(key);
				writeName = writeName+".ahk";
				writeFiles(writeName);
				count = 1;
				key++;
				hk.clear();
			}else {
				count++;
			}
			
		}
		if(hk.size() != 0)
		{
			String writeName = String.valueOf(key);
		writeName = writeName+".ahk";
		writeFiles(writeName);
		}
	}
		
	
	static void readFiles(String filename) 
	{
		try 
		{
			File file = new File(filename);
			Scanner read = new Scanner(file);
			while (read.hasNextLine()) 
			{
				String row = read.nextLine();
				lyrics.add(row);
			}
			read.close();
		} catch (Exception e) 
		{
			System.err.println("Sumtin wen rong");
			e.printStackTrace();
		}
	}
	
	static void writeFiles(String fileName)
	{
		try 
		{
			FileWriter writer = new FileWriter(fileName); 
			for(String str: hk) {
			  writer.write(str + System.lineSeparator());
			}
			writer.close();
		} catch (Exception e) 
		{
			System.err.println("Sumtin wen rong");
			e.printStackTrace();
		}
	}
}
