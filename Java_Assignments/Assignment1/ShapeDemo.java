import java.util.Scanner;

public class ShapeDemo
{
	public static Scanner userInput= new Scanner(System.in);
	public static void main(String[] args)
	{
		System.out.print("\t\tPOLYGON MAPPER\nEnter the number of sides:");
		int numberOfSides = userInput.nextInt();
		PolygonFactory myPolygonFactory = new PolygonFactory();
		Polygon myPolygon = myPolygonFactory.getPolygon(numberOfSides);
		if(myPolygon!=null)
		{
			System.out.println("Peremeter: "+myPolygon.getPeremeter());
			System.out.println("AngleSum: "+myPolygon.getAngleSum());
		}
		else
		{
			System.out.println("Please enter valid number of sides (3 to 10)");
		}	
	}
}