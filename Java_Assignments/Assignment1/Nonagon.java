class Nonagon extends Polygon
{
		
	int getPeremeter()
	{
		int perimeter=0;
		for(int count=0;count<9;count++)
		{
			System.out.print("Enter length of side "+(count+1)+": ");
			int nextSide=ShapeDemo.userInput.nextInt();
			perimeter+=nextSide;
		}
		return perimeter;
	}
	 
	int getAngleSum()
	{
		return 1260;
	}
}