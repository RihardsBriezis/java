public class MobilasLietotnes extends Lietotnes
{
	String company;
	boolean isAndroid;
	boolean isIOS;
	
	MobilasLietotnes(String name, int releseYear,String company, boolean isAndroid, boolean isIOS)
	{
		super(name, releseYear);
		this.company = company;
		this.isAndroid = isAndroid;
		this.isIOS = isIOS;
	}
	
	void getInfo()
	{
		System.out.println(this.company+ " released " + this.name+ " in " +this.releseYear);
	}
}
