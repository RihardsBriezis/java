import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebReader 
{
	static ArrayList<Episode> EpisodeList;
	String season;
	Boolean correctSeason = false;
	
	public WebReader()
	{
		this.EpisodeList = new ArrayList<Episode>();
		readPage();
		readScript();
		
	}
	
	void readPage() 
	{
		String url = "http://www.livesinabox.com/friends/scripts.shtml";
		Document page = getPage(url);
		Elements blocks = page.getElementsByTag("ul");
		int season = Main.vGar - 1;
		System.out.println(season);
		int i = 0;
		for(Element block : blocks) 
		{
			//System.out.println("ok");
			
			if (i == season)
			{
				readBlock(block);
				break;
			}
			
			i++;
		}
	}
	
	void readBlock(Element block)
	{
		Elements liTags = block.getElementsByTag("li");
		for(Element liTag : liTags)
		{
			String title = liTag.selectFirst("a").text();
			String link = liTag.selectFirst("a").attr("href");
			Episode ep = new Episode(title, link);
			//System.out.println(ep.episode);
			this.EpisodeList.add(ep);
		}
		
	}
	
	Document getPage(String url)
	{
		try {
			pause(100);
			Document page = Jsoup.connect(url).get();
			return page;
		} catch (Exception e){
			System.err.println("Couldn't get page");
			return null;
		}
	}

	private void pause(int millis) 
	{
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			
		}
	}
	
	void readScript()
	{
//		Episode a = EpisodeList.get(1);
//		String url = "http://www.livesinabox.com/friends/" +a.link;
//		Document script = getPage(url);
//		Elements lines = script.getElementsByTag("p");
//		for(Element line : lines)
//		{
//			readLine(line);
//		}
		
		for (int i = 0; i<EpisodeList.size(); i++)
		{
			String url = "http://www.livesinabox.com/friends/" +EpisodeList.get(i).link;
			Document script = getPage(url);
			Elements lines = script.getElementsByTag("p");
			int count = 0;
			for(Element line : lines)
			{
				if (count > 1)
				{
					readLine(line, i);
				}
				count++;
			}
		}
	}
	
	void readLine(Element line, int i)
	{
		System.out.println("ok");
		String person =  line.getElementsByTag("b").text();
		String x =  line.getElementsByTag("p").text();
		String pLines;
		if (x.contains(":"))
		{
			String[] y = x.split(":");
			//System.out.println(y);
			pLines = y[1];
			ScriptMaker sc = new ScriptMaker(person, pLines);
			Episode e = EpisodeList.get(i);
			e.Script.add(sc);
		}
	}
}
