import java.util.ArrayList;

public class Observer
{
	Vector3 direction;
	ScreenCoordinate screenSize;

	double fieldOfView;

	//right now I have it to where it will be stuck in the +z direction
	//for ease, but this can be changed later if I decide to project vectors
	//onto the direction vector

	public Observer()
	{
		direction  = new Vector3(0,0,1);
		screenSize = new ScreenCoordinate(500, 300);
		
		fieldOfView = 70.0;
	}

	public Observer(double fieldOfView)
	{
		direction  = new Vector3(0,0,1);
		screenSize = new ScreenCoordinate(500, 300);

		this.fieldOfView = fieldOfView;
	}

	//updates the screen with the new objects
	public ScreenCoordinate find(Vector3 objectPosition)
	{
		return ScreenCoordinate.fromVector3(objectPosition, direction, screenSize, fieldOfView);
	}

	//returns screen coordinates pairs from which to draw lines
	public ArrayList<ScreenCoordinate[]> lookAt(TriangularPyramid object)
	{
		ArrayList<ScreenCoordinate[]> cPairs = new ArrayList<ScreenCoordinate[]>();

		int i = 0;
		for (Vertice vertice : object.getVertices())
		{
			for(Vertice adjacent : vertice.getAdjacentVertices())
			{
				ScreenCoordinate[] points = new ScreenCoordinate[2];

				points[0] = find(new Vector3(vertice.getCoordinates()));
				points[1] = find(new Vector3(adjacent.getCoordinates()));

				cPairs.add(points);
				i++;
			}
		}

		return cPairs;
	}
}