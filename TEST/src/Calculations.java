package org.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Calculations {

	//Not much to explain
	static int getUsableCoastlineCountryRatio(ArrayList<Country> countriesList) {
		int count = 0;
		for (Country c : countriesList) {
			if (c.hasUsableCoastline())
				count++;
		}
		int noUsableCoastCount = countriesList.size() - count;
		int ratio = getRatio(count, noUsableCoastCount);
		System.out.println(ratio+"% have usable coastline");
		return ratio;
	}
	
	static void printMostPopulatedCountries(ArrayList<Country> countriesList, int limit) {
		//Sakārto padoto Country objektu sarakstu pēc defaultā kārtotāja (tā, kas ir Country klasē norādīts compareTo() metodē)
		Collections.sort(countriesList);
		System.out.println("Top " +limit+" populated countries");
		for (int i=0; i<countriesList.size() && i<limit; i++) {
			Country c = countriesList.get(i);
			System.out.println(c.name + " has "+ getMio(c.population)+" million");
		}
	}
	
	static void printMostDenseCountries(ArrayList<Country> countriesList, int limit) {
		//Šeit sakārto sarakstu, norādot atsevišķu salīdzinātāju. Pēc tam arī izvada vajadzīgo skaitu ciklā
		Collections.sort(countriesList, new DensityComparator());
		System.out.println("Top " +limit+" dense countries");
		for (int i=0; i<limit; i++) {
			Country c = countriesList.get(i);
			System.out.println(c.name +": "+c.density);
		}
	}
	
	//Palīgmetode, kas atgriež skaitli, pārveidotu miljonos, bet ar 2 cipariem aiz komata.
	static double getMio(long number) {
		double num = number;
		return (double)(Math.round(num / 10000)) / 100;
	}
	
	static int getRatio(double a, double b) {
		return (int)(a / (a + b) * 100);
	}
}
//get those that are top 20 in GDP, Literacy, Phones  (need new lists for these? or myb just c names)
class DensityComparator implements Comparator<Country> {
    public int compare(Country c1, Country c2) {
    	if (c1.density < c2.density) return 1;
		if (c1.density > c2.density) return -1;
		return 0;
    }
}
class LiteracyComparator implements Comparator<Country> {
	public int compare(Country c1, Country c2) {
    	if (c1.literacy < c2.literacy) return 1;
		if (c1.literacy > c2.literacy) return -1;
		return 0;
    }
}
//JFree chart stuff, 
//Some from DB and live things in there - palaist 2 progas - viena liek datus, otra refresho, r�da
//Corelation and more statistics
//		try to corelate multiple with EO to get the best