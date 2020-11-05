public class Lietotnes 
{
	String name;
	int releseYear;
	
	Lietotnes(String name, int releseYear)
	{
		this.name = name;
		this.releseYear = releseYear;
	}
	
	void getInfo()
	{
		System.out.println(this.name+ " was released in " +this.releseYear);
	}
}
