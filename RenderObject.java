import java.util.ArrayList;

public abstract class RenderObject
{
	public ArrayList<Vertice> vertices;

	public RenderObject()
	{
		vertices = new ArrayList<Vertice>();
	}
	
	public RenderObject(Vertice[] v)
	{
		vertices = new ArrayList<Vertice>();
		for (Vertice vertice : v)
		{
			vertices.add(vertice);
		}
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
			else if(v.equals(v2))
			{
				v.addAdjacentVertice(v1);
			}
		}
	}

	public ArrayList<Vertice> getVertices()
	{
		return vertices;
	}

	public abstract void rotate(Vector3 axis, double angle);
	
	public String toString()
	{
		String output = "";
		for (int i = 0; i < vertices.size(); i++)
		{
			output = output + "node " + (i + 1) + ": " + vertices.get(i) + "\n";
		}
		
		return output;
	}
}