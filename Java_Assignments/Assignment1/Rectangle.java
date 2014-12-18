class Rectangle extends Polygon
{
		
	int getPeremeter()
	{
		int perimeter=0;
		for(int count=0;count<4;count++)
		{
			System.out.print("Enter length of side "+(count+1)+": ");
			int nextSide=ShapeDemo.userInput.nextInt();
			perimeter+=nextSide;
		}
		return perimeter;
	}
	 
	int getAngleSum()
	{
		return 360;
	}
}