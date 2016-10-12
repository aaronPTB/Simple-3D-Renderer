import java.util.ArrayList;
public class TriangularPyramid extends RenderObject
{
	public ArrayList<Vertice> vertices;
	private Vector3 origin;

	//creates a triangular pyramid centered at >origin with size >size
	public TriangularPyramid(Vector3 orig, double size)
	{
		vertices = new ArrayList<Vertice>();
		origin = orig;
		
		//creating vertices
		Vertice top   = new Vertice(origin.getX(), origin.getY() + size, origin.getZ());
		Vertice back  = new Vertice(origin.getX(), origin.getY() - size/2, origin.getZ() + size/2);
		Vertice left  = new Vertice(origin.getX() - size/2, origin.getY() - size/2, origin.getZ() - size/2);
		Vertice right = new Vertice(origin.getX() + size/2, origin.getY() - size/2, origin.getZ() - size/2);
		
		Vertice[] actual = {top, left, back, right};
		for (Vertice vert : actual)
		{
			vertices.add(vert);
		}
		
		
		//connecting all vertices
		connectVertices(top, back );
		connectVertices(top, left );
		connectVertices(top, right);

		connectVertices(right, left);
		connectVertices(right, back);

		connectVertices(left, back);
	}
	
	/*Connects two vertices in an object so that on the screen,
	the edge formed by them will be represented by a line*/
	public void connectVertices(Vertice v1, Vertice v2)
	{
		for(Vertice v : vertices)
		{
			if (v.equals(v1))
			{
				v.addAdjacentVertice(v2);
			}
			else if (v.equals(v2))
			{
				v.addAdjacentVertice(v1);
			}
		}
	}

	
	//rotates each node in the entire model around a specified axis by a specified angle
	public void rotate(Vector3 axis, double angle)
	{
		ArrayList<Vertice> newVertices      = new ArrayList<Vertice>();

		int i = 0;
		for(Vertice vertice : vertices)
		{
			Vector3 nodePosition = new Vector3(origin.getCoordinates(),vertice.getCoordinates());
			
			Vector3  newPosition = nodePosition.rotate(axis, angle);

			vertices.get(i).setCoordinates(origin.plus(newPosition).getCoordinates());
			i++;
		}
	}
	
	//moves each node in the entire model by a specified Vector3 displacement
	public void move(Vector3 displacement)
	{
		origin.setCoordinates(origin.plus(displacement).getCoordinates());
		for (Vertice vertice : vertices)
		{
			Vector3 vertice3 = new Vector3(vertice.getCoordinates());
			vertice.setCoordinates(vertice3.plus(displacement).getCoordinates());
		}
	}
	
	//gets the origin of the model
	public Vector3 getOrigin()
	{
		return origin;
	}
	
	//returns all vertices of the model
	public ArrayList<Vertice> getVertices()
	{
		return vertices;
	}
	
	public String toString()
	{
		String output = "";
		for (int i = 0; i < vertices.size(); i++)
		{	
			vertices.get(i).round(4);
			output = output + "node " + (i + 1) + ": " + vertices.get(i) + "\n";
		}
		
		return output;
	}
}