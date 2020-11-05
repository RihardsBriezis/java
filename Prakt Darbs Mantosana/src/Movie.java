public class Movie extends Films
{
	String leadActor;
	Movie(String title, int releseYear, String leadActor )
	{
		super(title, releseYear);
		//System.out.println("child 1");
		this.leadActor = leadActor;
		this.title = "Movie: " +title;
	}
	Movie(String title, int releseYear)
	{
		super(title, releseYear);
		this.title = "Movie: " +title;
	}
	
	void getInfo()
	{
		super.getInfo();
		if(this.leadActor == null)
		{
			System.out.println("No lead actor specified");
		}else {
			System.out.println("And the lead actor is " +this.leadActor+ ". But the best actor ever is: " +this.bestActor+ ".");
		}
	}
}
