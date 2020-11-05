public class DesktopLietotnes extends Lietotnes
{
	String company;
	boolean isOnSteam;
	String mainOS;
	
	DesktopLietotnes(String name, int releseYear, String company, boolean isOnSteam, String mainOS) {
		super(name, releseYear);
		this.company = company;
		this.isOnSteam = isOnSteam;
		this.mainOS = mainOS;
	}
	
	void getInfo()
	{
		System.out.println(this.company+ " released " + this.name+ " in " +this.releseYear);
	}
}
