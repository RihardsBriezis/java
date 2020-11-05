package org.calc;
					//Implementē Comparable interfeisu, kas norāda, pēc kā tiks salīdzināti objekti Collections.sort() metodē
public class Country implements Comparable<Country> {
	String name;
	long population;
	double density;
	double coastline;
	double literacy;
	//privāts mainīgais, lai nebūtu pieejams/maināms no citām klasēm. Tiek izmantots tikai šajā
	private double usableCoastlineLimit = 1; //km - good for ports
	
	//Konstruktorā datus ņem no padotā masīva
	public Country(String[] data) {
		this.name = data[0].trim();
		this.population = Long.parseLong(data[2]);
		this.density = badStringToDouble(data[4]);
		this.coastline = badStringToDouble(data[5]);
		this.literacy = badStringToDouble(data[9]);
	}
	public boolean hasCoastline() {
		return this.coastline > 0;
	}
	
	public boolean hasUsableCoastline() {
		return this.coastline > usableCoastlineLimit;
	}
	
	//Palīgmetode, lai korekti pārveidotu decimālskaitļus no faila
	//Tur tie ir norādīti kā "12,42" vai dažviet tukšums
	//Metodes sākumā ir Guard statement, kas "izķer" iespējamās metodei nederīgās vērtības
	public double badStringToDouble (String num) {
		if (num==null || num.length()==0) return 0;
		num = num.replace(",", ".");
		return Double.parseDouble(num);
	}
	
	//Metode vajadzīga Collections.sort() metodei. Šeit tiek norādīts, pēc kā Country objekti tiks kārtoti.
	//Šeit tiek pārrakstīta esoša (by default Comaprable interfeisam) metode compareTo()
	//Pozitīvs skaitlis nozīmē, ka šis objekts būs sarakstā augstāk, negatīvs - zemāk nekā tas objekts, ar ko salīdzina
	@Override
	public int compareTo(Country o) {
		if (this.population < o.population) return 1;
		if (this.population > o.population) return -1;
		return 0;
	}
}
