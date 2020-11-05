public class TVShow extends Films
{
	int endYear;
	
	TVShow(String title, int releaseYear, int endYear)
	{
		super(title, releaseYear);
		this.endYear = endYear;
		this.title = "TV Show: " +title;
	}
	TVShow(String title, int releseYear)
	{
		super(title, releseYear);
		this.title = "TV Show: " +title;
	}
	
	void getInfo()
	{
		super.getInfo();
		if(this.endYear > 0)
		{
			System.out.println("This show ended in " +this.endYear+ ".");
		}else {
			System.out.println("This show has yet to end.");
		}
		
	}

}
