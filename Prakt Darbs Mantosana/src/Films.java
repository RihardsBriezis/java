public class Films 
{
	String title;
	int releaseYear;
	final String bestActor;
	private String worstActor;
	
	Films(){
		//System.out.println("Parent 1");
		this.bestActor = "Keanu Reeves"; //And that's a fact!!! No one can change that!
		this.worstActor = "Tommy Wiseau"; //"Oh Hi Mark!"
	}
	
	Films(String t, int y)
	{
		//System.out.println("Parent 2");
		this.title = t;
		this.releaseYear = y;
		this.bestActor = "Keanu Reeves"; //And that's a fact!!! No one can change that!
		this.worstActor = "Tommy Wiseau"; //"Oh Hi Mark!"
	}
	
	void getInfo()
	{
		System.out.println(this.title+ " was relesed in " +this.releaseYear+ ".");
	}
}
