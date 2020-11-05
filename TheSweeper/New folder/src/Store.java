import java.util.ArrayList;

public class Store 
{
	String name;
	private ArrayList<Purchase> purchases;
	
	public Store(String name)
	{
		this.name = name;
		this.purchases = new ArrayList<Purchase>();
	}
	
	void addPurchase(Purchase p)
	{
		this.purchases.add(p);
	}
	
	int getPurchaseCount()
	{
		return this.purchases.size();
	}
	double getPurchaseTotalValue()
	{
		double sum = 0;
		for(Purchase p : purchases)
		{
			sum += p.cost;
		}
		return sum;
	}
}
