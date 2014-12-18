class PolygonFactory
{
	Polygon getPolygon(int numberOfSides)
	{
		switch (numberOfSides)
		{
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