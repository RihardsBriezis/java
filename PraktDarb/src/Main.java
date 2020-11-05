
public class Main 
{
	public static int vGar;
	public static void main(String[] args)
	{
		String vards = "Rihards";
		vGar = vards.length();
		if(vards.length() > 10) 
		{
			int a = vards.length();
			int b = a / 10;
			vGar = a -b*10;
		}
		System.out.println(vGar);
		new WebReader();
		
	}

}
