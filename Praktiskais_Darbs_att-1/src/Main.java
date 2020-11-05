import java.awt.RenderingHints.Key;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main 
{
	static HashMap<String, Company> companyData = new HashMap<String, Company>();
	public static void main(String[] args) 
	{
		String filePath = "companyData.txt";
		readFiles(filePath);
		String dealPath = "deals.XXXsv";
		dealFile(dealPath);
		//System.out.println(companyData.keySet());
		companySalesAndPurchases();
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
				String[] data = row.split(" - ");
				//System.out.println(data[0]);
				Company comp = new Company(data);
				companyData.put(comp.name, comp);
			}
			read.close();
		} catch (Exception e) 
		{
			System.err.println("Sumtin wen rong");
			e.printStackTrace();
		}
	}
	
	static void dealFile(String filename)
	{
		try 
		{
			File file = new File(filename);
			Scanner read = new Scanner(file);
			int line = 1;
			int emptyString = 0;
			int error = 0;
			int late_document_submit = 0;
			while (read.hasNextLine()) 
			{
				String row = read.nextLine();
				//System.out.println(row);
				if (row.length() == 0)
				{
					//System.out.println("error line " +line);  //prints invalid line in .XXXsv docunent.
					line++;
					emptyString++;
					continue;
				}
				if (row.equals("ERROR"))
				{
					//System.out.println("error line " +line);  //prints invalid line in .XXXsv docunent.
					line++;
					error++;
					continue;
				}
				if (row.equals("LATE_DOCUMENT_SUBMIT"))
				{
					//System.out.println("error line " +line);  //prints invalid line in .XXXsv docunent.
					line++;
					late_document_submit++;
					continue;
				}
				String[] data = row.split("XXX");
				//System.out.println(data[0]);
				Deal deals = new Deal(data);
				companyData.get(deals.buyer).purchases.add(deals);
				companyData.get(deals.seller).sales.add(deals);
				line++;
			}
			
			System.out.println("There where " +emptyString+ " empty rows " +error+ " errors and " +late_document_submit+ " documents that where submitted to late. \n");
			read.close();
		} catch (Exception e) 
		{
			System.err.println("Sumtin wen rong");
			e.printStackTrace();
		}
	}
	
	static void companySalesAndPurchases()
	{
		int transactionCount = 0;
		double allEndBilance = 0;
		double allStartBilance = 0;
		double totalTransactionSumm = 0;
		HashMap<String, Double> mostMoneySpent = new HashMap<String, Double>();
		HashMap<String, Integer> mostSales = new HashMap<String, Integer>();
		
		for(String key : companyData.keySet())
		{
			Double s = getSalesTotal(key);
			Double p = getPurchasesTotal(key);
			Double startCap = companyData.get(key).startingCapital;
			startCap = roundToAMillion(startCap);
			Double endBal = startCap - s - p;
			endBal = roundToAMillion(endBal);
			System.out.println(key+ "'s total purchases: " +p+ "M , total sales: " +s+ "M and end balance: " +endBal+ "M");
			
			mostMoneySpent.put(key, s);
			int totsales = totalSalesCount(key);
			mostSales.put(key, totsales);
			
			transactionCount = transactionCount + totalTransactionCount(key);
			allEndBilance = allEndBilance + endBal;
			allStartBilance = allStartBilance + startCap;
			
			totalTransactionSumm = totalTransactionSumm + s + p ;
			totalTransactionSumm = roundToAMillion(totalTransactionSumm);
		}
		System.out.println("\n Total Transactions: " +transactionCount);
		System.out.println("Total starting capital: " +allStartBilance+ "M");
		System.out.println("Total ending bilance: " +allEndBilance+ "M");
		
		String max_key = Collections.max(mostMoneySpent.entrySet(), Map.Entry.comparingByValue()).getKey();
		System.out.println(max_key+ " has spent the most in sales.");
		String most_key = Collections.max(mostSales.entrySet(), Map.Entry.comparingByValue()).getKey();
		System.out.println(most_key+ " has made the most sales.");
		
		System.out.println("Avarage transaction summ: " +totalTransactionSumm/transactionCount+ "M");
	}
	
	static double getSalesTotal(String key)
	{
		double totalSumm = 0;
		for (int i = 0; i<companyData.get(key).sales.size(); i++)
		{
			totalSumm = totalSumm + companyData.get(key).sales.get(i).summ;
			//System.out.println(totalSumm/1000000);
		}
		totalSumm = roundToAMillion(totalSumm);
		return totalSumm;
	}
	
	static double getPurchasesTotal(String key)
	{
		double totalSumm = 0;
		for (int i = 0; i<companyData.get(key).purchases.size(); i++)
		{
			totalSumm = totalSumm + companyData.get(key).purchases.get(i).summ;
			//System.out.println(totalSumm/1000000);
		}
		totalSumm = roundToAMillion(totalSumm);
		return totalSumm;
	}
	
	static double roundToAMillion(double number)
	{
		return Math.round(number / 10000);
	}

	static int totalTransactionCount(String key)
	{
		int totalCount = 0;
		for (int i = 0; i<companyData.get(key).sales.size(); i++)
		{
			totalCount++;
		}
		for (int i = 0; i<companyData.get(key).purchases.size(); i++)
		{
			totalCount++;
		}
		
		return totalCount;

	}

	static int totalSalesCount(String key)
	{
		int totalCount = 0;
		for (int i = 0; i<companyData.get(key).sales.size(); i++)
		{
			totalCount++;
		}
		return totalCount;
	}
}
