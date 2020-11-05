import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class webReader 
{
	static ArrayList<manga> MangaList;
	static String baseURL = "https://myanimelist.net/topmanga.php?type=bypopularity";
	public webReader()
	{
		this.MangaList = new ArrayList<manga>();
		readPage();
		//System.out.println("We have " +MangaList.size()+ " manga");
		topManga(MangaList);
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
	
	void pause(int millis)
	{
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			
		}
	}
	
	void readPage() 
	{
		String url = baseURL;
		Document page = getPage(url);
		Elements blocks = page.getElementsByClass("ranking-list");
		for(Element block : blocks) {
			readBlock(block);
		}
	}
	
	void readBlock(Element block)
	{
		String title = block.selectFirst("div.detail a").text();
		String link = block.selectFirst("div.detail a").attr("href");
		String score = block.selectFirst("div.js-top-ranking-score-col span").text();
		//System.out.println(title+ " has a rating of " +score);
		manga m = new manga(title, link, score);
		//System.out.println(m.title);
		this.MangaList.add(m);
	}
	static void topManga(ArrayList<manga> mangaList) 
	{
		Collections.sort(mangaList, new scoreComparator());
		for (int i=0; i<mangaList.size(); i++) {
			manga c = mangaList.get(i);
			System.out.println(c.title +": "+c.rating);
		}
	}
	
	static class scoreComparator implements Comparator<manga> {
	    public int compare(manga c1, manga c2) {
	    	if (c1.rating < c2.rating) return 1;
			if (c1.rating > c2.rating) return -1;
			return 0;
	    }
	}
	
}
