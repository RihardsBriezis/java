import java.util.ArrayList;

public class Person
{
	String name;
	String adress;
	int age;
	Double monthlyIncome;
	Profession prof;
	
	Person(String name, String adress, int age, Double monthlyIncome, String profName, String industry, Double minIncome)
	{
		this.name = name;
		this.adress = adress;
		this.age = age;
		this.monthlyIncome = monthlyIncome;
		this.prof = new Profession(profName, industry, minIncome); //Izveido amatu objektu
	}
	
	public Double diffInIncome(ArrayList<Person> list)
	{
		Double income = 0.0;
		int personCount = 0;
		for(Person p : list)
		{
			Profession pro = p.prof;
			if(pro.name == this.prof.name)// ja sakrīt profesiju nosaukumi, tad pieskaita personas algu.
			{
				income = income + p.monthlyIncome;
				personCount++; // saskaita cik personu ar konkreto amatu ir
			}
		}
		//System.out.println(income);
		return income/personCount - this.monthlyIncome; // aprēķina vidējo algu un atņem konkrētās personas algu
	}
	
	public Double yearIncome() // aprēķina gada algu
	{
		return this.monthlyIncome * 12;
	}
	
	public void printInfo() // izprinte personas info
	{
		System.out.println(this.name+ " lives in " +this.adress+ " and works as a " +this.prof.name+ " in " +this.prof.industry);
	}
}
