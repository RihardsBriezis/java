import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.jfree.chart.axis.SymbolicTickUnit;

public class Sweep 
{
	static String[] files = {"Chicago" , "Colombia" , "Denmark" , "Iowa" , "Latvia" , "Mongolia" , "NewZealand" , "Taiwan"};
	static String[] payment = {"cash "  , "card"};
	static String ext = ".txt";
	static String root = "D:\\Users\\ctudent08\\Desktop\\TheSweeper\\";  
	
	static ArrayList<Purchase> purch = new ArrayList<Purchase>();
	static HashMap<String, Store> stores = new HashMap<String, Store>();
	
	public static void main(String[] args) 
	{
		readFiles();
		showChart();
		//countPurchasesByStore();
	}
	
	static void showChart()
	{
		TheChart chart = new TheChart();
		int[] items = countPurchasesByStore();
		String[] names = getStoreNames();
		double[] prives = getPurchasePricesTotal();
		chart.makeCountBarChart(names, items, prives);
	}
	
	static void readFiles()
	{
		for (String name : files)
		{
			Store store = new Store(name);
			stores.put(name, store);
			//System.out.println(root+name+ext);
			readFile(root+name+ext, store);
		}
	}
	
	static void readFile(String filename, Store store)
	{
		try {
			File file = new File(filename);
			Scanner read = new Scanner(file);
			while (read.hasNextLine()) {
				String row = read.nextLine();
				//System.out.println(row);
				if (row.length() == 0) continue;
				String[] data = row.split("\\$");
				//System.out.println(data[0]);
				Purchase p = new Purchase(data, store);
				purch.add(p);
			}
			read.close();
		} catch (Exception e) 
		{
			System.err.println("Sumtin wen rong");
			e.printStackTrace();
		}
	}
	
	static int[] countPurchasesByStore()
	{
		int[] pItemsArray = new int[stores.keySet().size()];
		int i=0;
		for(String name : stores.keySet())
		{
			Store store = stores.get(name);
			int pItems = store.getPurchaseCount();
			pItemsArray[i] = pItems;
			i++;
		}
		return pItemsArray;
	}
	
	static String[]getStoreNames()
	{
		String[] storeNames = new String[stores.keySet().size()];
		int i=0;
		for(String storeName : stores.keySet())
		{
			storeNames[i] = storeName;
			i++;
		}
		return storeNames;
	}
	static double[] getPurchasePricesTotal()
	{
		double[] pItemsArray = new double[stores.keySet().size()];
		int i=0;
		for(String name : stores.keySet())
		{
			Store store = stores.get(name);
			int pItems = store.getPurchaseCount();
			pItemsArray[i] = pItems;
			i++;
		}
		return pItemsArray;
	}
}
