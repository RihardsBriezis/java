import java.util.ArrayList;

public class Episode 
{
	String episode;
	String title;
	String link;
	static ArrayList<ScriptMaker> Script = new ArrayList<ScriptMaker>();
	
	public Episode(String ep, String link)
	{
		String[] epArray = ep.split(":");
		this.episode = epArray[0];
		this.title = epArray[1];
		this.link = link;
	}
}
