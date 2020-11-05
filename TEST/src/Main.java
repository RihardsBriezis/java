package org.calc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	//divi saraksti dažādai objektu piekļuvei
	static ArrayList<Country> countriesList = new ArrayList<Country>();
	static HashMap<String, Country> countriesMap = new HashMap<String, Country>(); 

	public static void main(String[] args) {
		String fileUrl = "C:\\Users\\Pasniedzejs\\Desktop\\Countries of the world.csv";
		//Vispirms tiek ielasīti dati no faila - saglabāti sarakstos
		readCountries(fileUrl);
		
		//Izsauc dažādas aprēķinu metodes.
		//Metodes izsauc konkrēti pašai klasei, nevis kādam objektam
		//Lai varētu izsaukt metodes klasei, konkrētajām metodēm jābūt ar atslēgvārdu static
		Calculations.getUsableCoastlineCountryRatio(countriesList);
		Calculations.printMostPopulatedCountries(countriesList, 10);
		Calculations.printMostDenseCountries(countriesList, 20);
	}
	
	/*
	 Nolasa csv failu.
	 Lasa to pa rindām, izlaižot pirmās piecas.
	 Katru rindu sadala pēc atdalītāja ";", iegūstot vērtību masīvu
	 Masīvu padod Country() konstruktoram, no kura izveidojas objekts
	 Objekta referenci ieliek 2 sarakstos.
	 * */
	static void readCountries(String filename) {
		try {
			File file = new File(filename);
			Scanner read = new Scanner(file);
			int i = 0;
			while (read.hasNextLine()) {
				i++;
				String row = read.nextLine();
				if (i<6) continue;
				String[] data = row.split(";");
				Country c = new Country(data);
				countriesList.add(c);
				countriesMap.put(c.name, c);
			}
			read.close();
		} catch (Exception e) {
			System.err.println("Sumtin wen rong");
			e.printStackTrace();
		}
	}

}
