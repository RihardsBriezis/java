import java.util.ArrayList;

public class Robots 
{
	String name;
	String type;
	String material;
	int manifacturingYear;
	Language nativeLang;
	ArrayList<Language> languages;
	
	Robots(String name, String type, String material, int manifacturingYear, Language nativeLang) 
	{
		this.name = name;
		this.type = type;
		this.material = material;
		this.manifacturingYear = manifacturingYear;
		this.nativeLang = nativeLang;
		this.languages = new ArrayList<Language>(); // izveido arrayList ar valodam
		this.languages.add(nativeLang); // pievieno pirmo valodu arrayList
	}
	
	void addNewLang(Language lang) // pievieno jaunu valodu arraylist
	{
		if(languages.contains(lang))
		{
			return;
		}
		this.languages.add(lang);
	}
	
	void printBotLangs() // izdruka visas valodas, kuras māk robots
	{
		System.out.println(this.name+ " knows these languages: ");
		for(Language l : languages)
		{
			System.out.println(l.name);
		}
	}
	
	void botKnowsLang(Language lang)
	{
		if(this.languages.contains(lang))// pārbauda vai robots zin šo valodu
		{
			System.out.println("These bots can comunicate with " +this.name+ "; ");
			for(Robots lessgo : lang.bots) // iet cauri valodas robotu sarakstam un izdruka visus parejo robotus, kuri zin so valodu
			{
				if(lessgo.name.equals(this.name))
				{
					continue;
				}else {
					System.out.println(lessgo.name);
				}
			}
		}else {
			System.out.println(this.name+ " does not know the language " +lang.name);
		}
	}
}
