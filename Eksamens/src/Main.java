import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args) 
	{
		//-------------FIRST-TASK-------------------
		System.out.println("-------------FIRST-TASK-------------------\n");
		ArrayList<Person> firstList = new ArrayList<Person>();
		
		//Izveido personu objektus ar attiecīgajām profesijām
		Person p1 = new Person("James" , "Brodway st." , 32 , 960.23 , "Jr.Banker" , "Banking" , 860.25);
		Person p2 = new Person("Keanu" , "La" , 47 , 30000.23 , "Actor" , "Acting" , 28000.79);
		Person p3 = new Person("Jānis" , "Riga" , 20 , 860.46 , "Programmer" , "IT" , 742.62);
		Person p4 = new Person("Olaf" , "Berlin" , 62 , 1250.23 , "Jr.Banker" , "Banking" , 860.25);
		
		//Izveidotos objektus saliek ArrayList
		firstList.add(p1);
		firstList.add(p2);
		firstList.add(p3);
		firstList.add(p4);
		
		//Padodot arrayList tiek apreķināts vidējais algu amatā, kas ir konkrētajai personai un tad atgriež starpību starp šo vidējo un personas algu, ko pēctam izvada string
		Double incomeDiff = p1.diffInIncome(firstList);
		System.out.println(incomeDiff);
		
		Person leastIncome = firstList.get(0); 
		for(Person p : firstList) //ejot cauri arraylist atrod vismazako gada algu
		{
			Double a = leastIncome.yearIncome();
			Double b = p.yearIncome();
			if (b < a)
			{
				leastIncome = p;
			}
		}
		leastIncome.printInfo();
		
		//-------------SECOND-TASK-------------------
		System.out.println("\n-------------SECOND-TASK-------------------\n");
		
		ArrayList<Robots> robs = new ArrayList<Robots>();
		
		Language eng = new Language("English" , "Eng" , "don'tKnow" , 10000.5);
		Language rus = new Language("Russian" , "Rus" , "Hem" , 7542.2);
		
		Robots r1 = new Robots("Mr.WoofWoof" , "DoggoBOT" , "coldHardSteel" , 2424 , eng);
		Robots r2 = new Robots("YourAWizzardHarry" , "HagridBOT" , "SoftThings" , 1999 , rus);
		
		r1.addNewLang(rus); // Pievieno jaunu valodu
		
		robs.add(r1);
		robs.add(r2);
		
		// Valodai pievieno katru robotu, kas prot to valodu
		for(Robots robobros : robs) 
		{
			for(Language langs : robobros.languages)
			{
				langs.addBot(robobros);
			}
		}
		
		r1.printBotLangs();
		eng.printBotsWhoKnowDotDotDot();
		r1.botKnowsLang(eng); // taka man ir tikai 2 robotu objekti saja gadijuma neizdruka citu robotu nosaukumus
		r2.botKnowsLang(rus);
		
		//-------------THIRD-TASK-------------------
		System.out.println("\n-------------THIRD-TASK-------------------\n");
		
		ArrayList<Lietotnes> Liet = new ArrayList<Lietotnes>();
		
		Lietotnes l1 = new MobilasLietotnes("FruitNinja", 2011, "Antiplex", true, true);
		Lietotnes l2 = new DesktopLietotnes("GTA", 1998, "RockstarGames", true, "Windows");
		
		Liet.add(l1);
		Liet.add(l2);
		
		for(Lietotnes l : Liet) // katrai Lietotnei izdruka info
		{
			l.getInfo();
		}
	}
}
