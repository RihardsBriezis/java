public class Purchase 
{
	String name;
	int count;
	double cost;
	String type; // payment method (card|cash)
	
	public Purchase(String[] string, Store myStore)
	{
		this.name = string[0];
		this.count = stringToInt(string, 1);
		this.cost = stringToDouble(string, 2);
		this.type = string[3];
		myStore.addPurchase(this);
	}
	
	public int stringToInt(String[] arr, int i)
	{
		if (arr.length<=i) return 0;
		String num = arr[i];
		if(num.length()== 0) return 0;
		return Integer.parseInt(num);
	}
	public double stringToDouble(String[] arr, int i)
	{
		if (arr.length<=i) return 0;
		String num = arr[i];
		if(num.length()== 0) return 0;
		return Double.parseDouble(num);
	}
}

