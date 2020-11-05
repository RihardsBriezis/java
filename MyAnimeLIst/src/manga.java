import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class manga 
{
	String title;
	String url;
	Double  rating;
	
	public manga(String title, String url, String rating)
	{
		this.title = title;
		this.url = url;
		this.rating = stringToDouble(rating);
	}
	
	public double stringToDouble(String r) 
	{
		return Double.parseDouble(r);
	}
}
