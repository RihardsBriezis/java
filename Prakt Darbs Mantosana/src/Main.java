import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Main 
{
	static ArrayList<Films> filmsList = new ArrayList<Films>();
	public static void main(String[] args) 
	{
		//Films f1 = new Films("\"The Imitation Game\"" , 2014);
		//f1.getInfo();
		//Movie m1 = new Movie("\"Sherlock Holmes: A Game of Shadows\"" , 2011);
		//m1.getInfo();
		//TVShow s1 = new TVShow("\"Patric Melrose\"", 2018, 2018); //Specify end year after release year if the tv show has ended
		//TVShow s2 = new TVShow("\"Cardinal 4\"", 2020);//If the TV show is ongoing don't write the end year
		//s1.getInfo();
		//s2.getInfo();
		
		readFilms();
		System.out.println();
		for(Films f : filmsList)
		{
			f.getInfo();
//			if("TVShow".equals(f.getClass().getSimpleName()))
//			{
//				TVShow temp = (TVShow)f;
//				if(temp.endYear != 0) 
//				{
//					System.out.println("End year" +temp.endYear);
//				}
//			}
		}
	}
	
		static void readFilms() {
		try {
			File file = new File("films.txt");
			Scanner read = new Scanner(file);
			System.out.println("Read Successful! \n");
			while (read.hasNextLine()) {
				//System.out.println("OK");
				String row = read.nextLine();
				String[] data = row.split(";");
				if(data[0].contentEquals("TV"))
				{
					int rY = Integer.parseInt(data[2]);
					if (data.length == 4)
					{
						int eY = Integer.parseInt(data[3]);
						System.out.println(data[1]);
						Films s = new TVShow(data[1], rY, eY);
						filmsList.add(s);
					}else {
						System.out.println(data[1]);
						Films s = new TVShow(data[1], rY);
						filmsList.add(s);
					}
					
				}else if (data[0].contentEquals("Movie"))
				{
					int rY = Integer.parseInt(data[2]);
					if(data.length == 4)
					{
						System.out.println(data[1]);
						Films m = new Movie(data[1], rY, data[3]);
						filmsList.add(m);
					}else {
						System.out.println(data[1]);
						Films m = new Movie(data[1], rY);
						filmsList.add(m);
					}
				}
			}
			read.close();
		} catch (Exception e) {
			System.err.println("Sumtin wen rong");
			e.printStackTrace();
		}
	}
}
