import java.util.ArrayList;

public class Company 
{
	String name;
	Double startingCapital;
	ArrayList<Deal> purchases;
	ArrayList<Deal> sales;
	
	public Company(String[] company)
	{
		this.name = company[0];
		this.startingCapital = stringToDouble(company[1]);
		this.purchases = new ArrayList<Deal>();
		this.sales = new ArrayList<Deal>();
		
	}
	
	static double stringToDouble(String num)
	{
			if (num==null || num.length()==0) return 0;
			num = num.replace("," , ".");
			return Double.parseDouble(num);
	}
}
