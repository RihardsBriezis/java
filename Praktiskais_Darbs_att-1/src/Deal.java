public class Deal 
{
	String buyer;
	String seller;
	Double summ;
	String dealNumber;
	
	public Deal(String[] deals)
	{
		this.buyer = deals[0];
		this.seller = deals[1];
		this.summ = stringToDouble(deals[2]);
		this.dealNumber = deals[3];
	}
	
	static double stringToDouble(String num)
	{
		
		if (num==null || num.length()==0) return 0;
		num = num.substring(0, num.length()-1);
		return Double.parseDouble(num);
	}
}
