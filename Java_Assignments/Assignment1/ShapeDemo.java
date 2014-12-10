import java.util.Scanner;


public class ShapeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput= new Scanner(System.in);
		System.out.print("\t\tPOLYGON MAPPER\nEnter the number of sides:");
		int numberOfSides = userInput.nextInt();
		userInput.close();
		PolygonFactory myPolygonFactory = new PolygonFactory();
		Polygon myPolygon = myPolygonFactory.getPolygon(numberOfSides);
		if(myPolygon!=null)
		{
			System.out.println("Peremeter: "+myPolygon.getPeremeter());
			System.out.println("AngleSum: "+myPolygon.getAngleSum());
		}
		else{
			System.out.println("Please enter valid number of sides (3 to 10)");
		}
		
	}
}

class PolygonFactory {
	Polygon getPolygon(int numberOfSides) {
		switch (numberOfSides) {
		case 3:
			return new Traingle();
		case 4:
			return new Rectangle();
		case 5:
			return new Pentagon();
		case 6:
			return new Hexagon();
		case 7:
			return new Heptagon();
		case 8:
			return new Octagon();
		case 9:
			return new Nonagon();
		case 10:
			return new Decagon();
		default:
			return null;
		}
	}
}

abstract class Polygon{
	abstract int getPeremeter();
	abstract int getAngleSum();
}

class Traingle extends Polygon{
	
	 int getPeremeter(){
		 Scanner userInput = new Scanner(System.in);
		 int perimeter=0;
		 for(int count=0;count<3;count++)
		 {
			 System.out.print("Enter length of side "+(count+1)+": ");
			 int nextSide=userInput.nextInt();
			 perimeter+=nextSide;
		 }
		 userInput.close();
		 return perimeter;
	 }
	 
	 int getAngleSum(){
		 return 180;
	 }
	}

 class Rectangle extends Polygon{
		
	 int getPeremeter(){
		 Scanner userInput = new Scanner(System.in);
		 int perimeter=0;
		 for(int count=0;count<4;count++)
		 {
			 System.out.print("Enter length of side "+(count+1)+": ");
			 int nextSide=userInput.nextInt();
			 perimeter+=nextSide;
		 }
		 userInput.close();
		 return perimeter;
	 }
	 
	 int getAngleSum(){
		 return 360;
	 }
	}
 
 class Pentagon extends Polygon{
		
	 int getPeremeter(){
		 Scanner userInput = new Scanner(System.in);
		 int perimeter=0;
		 for(int count=0;count<5;count++)
		 {
			 System.out.print("Enter length of side "+(count+1)+": ");
			 int nextSide=userInput.nextInt();
			 perimeter+=nextSide;
		 }
		 userInput.close();
		 return perimeter;
	 }
	 
	 int getAngleSum(){
		 return 540;
	 }
	}
 
 class Hexagon extends Polygon{
		
	 int getPeremeter(){
		 Scanner userInput = new Scanner(System.in);
		 int perimeter=0;
		 for(int count=0;count<6;count++)
		 {
			 System.out.print("Enter length of side "+(count+1)+": ");
			 int nextSide=userInput.nextInt();
			 perimeter+=nextSide;
		 }
		 userInput.close();
		 return perimeter;
	 }
	 
	 int getAngleSum(){
		 return 720;
	 }
	}
 
 class Heptagon extends Polygon{
		
	 int getPeremeter(){
		 Scanner userInput = new Scanner(System.in);
		 int perimeter=0;
		 for(int count=0;count<7;count++)
		 {
			 System.out.print("Enter length of side "+(count+1)+": ");
			 int nextSide=userInput.nextInt();
			 perimeter+=nextSide;
		 }
		 userInput.close();
		 return perimeter;
	 }
	 
	 int getAngleSum(){
		 return 900;
	 }
	}
 
 class Octagon extends Polygon{
		
	 int getPeremeter(){
		 Scanner userInput = new Scanner(System.in);
		 int perimeter=0;
		 for(int count=0;count<8;count++)
		 {
			 System.out.print("Enter length of side "+(count+1)+": ");
			 int nextSide=userInput.nextInt();
			 perimeter+=nextSide;
		 }
		 userInput.close();
		 return perimeter;
	 }
	 
	 int getAngleSum(){
		 return 1080;
	 }
	}
 
 class Nonagon extends Polygon{
		
	 int getPeremeter(){
		 Scanner userInput = new Scanner(System.in);
		 int perimeter=0;
		 for(int count=0;count<9;count++)
		 {
			 System.out.print("Enter length of side "+(count+1)+": ");
			 int nextSide=userInput.nextInt();
			 perimeter+=nextSide;
		 }
		 userInput.close();
		 return perimeter;
	 }
	 
	 int getAngleSum(){
		 return 1260;
	 }
	}
 
 class Decagon extends Polygon{
		
	 int getPeremeter(){
		 Scanner userInput = new Scanner(System.in);
		 int perimeter=0;
		 for(int count=0;count<3;count++)
		 {
			 System.out.print("Enter length of side "+(count+1)+": ");
			 int nextSide=userInput.nextInt();
			 perimeter+=nextSide;
		 }
		 userInput.close();
		 return perimeter;
	 }
	 
	 int getAngleSum(){
		 return 1440;
	 }
	}
 
