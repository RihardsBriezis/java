import java.util.ArrayList;

public class Language 
{
	String name;
	String shortName;
	String langGroup;
	Double existanceTime;
	ArrayList<Robots> bots;
	
	Language(String name, String shortName, String langGroup, Double existanceTime) 
	{
		this.name = name;
		this.shortName = shortName;
		this.langGroup = langGroup;
		this.existanceTime = existanceTime;
		this.bots = new ArrayList<Robots>();
	}
	
	void addBot(Robots robs) // pievieno robotus valodas listam
	{
		if(bots.contains(robs))
		{
			return;
		}
		this.bots.add(robs);
	}
	
	void printBotsWhoKnowDotDotDot() // izdruka visus robotus, kuri māk šo valodu
	{
		System.out.println("Robots that know " +this.name+ ":");
		for(Robots r : bots)
		{
			System.out.println(r.name);
		}
	}
}
