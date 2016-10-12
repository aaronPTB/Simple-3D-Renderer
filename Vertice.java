import java.util.ArrayList;

public class Vertice
{
	private double x, y, z;
	public ArrayList<Vertice> adjacentVertices;

	public Vertice(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;

		adjacentVertices = new ArrayList<Vertice>();
	}

	public Vertice(double[] coords)
	{
		x = coords[0];
		y = coords[1];
		z = coords[2];

		adjacentVertices = new ArrayList<Vertice>();
	}

	public Vertice(double[] coords, Vertice[] adjVertices)
	{
		x = coords[0];
		y = coords[1];
		z = coords[2];

		adjacentVertices = new ArrayList<Vertice>();
		for (Vertice vertice : adjVertices)
		{
			adjacentVertices.add(vertice);
		}
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public double getZ()
	{
		return z;
	}

	public void setX(double set)
	{
		x = set;
	}

	public void setY(double set)
	{
		y = set;
	}

	public void setZ(double set)
	{
		z = set;
	}

	public double[] getCoordinates()
	{
		double[] coords = {x, y, z};
		return coords;
	}

	public void setCoordinates(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void setCoordinates(double[] coords)
	{
		x = coords[0];
		y = coords[1];
		z = coords[2];
	}


	public void addAdjacentVertice(Vertice v)
	{
		adjacentVertices.add(v);
	}

	public ArrayList<Vertice> getAdjacentVertices()
	{
		return adjacentVertices;
	}

	public boolean equals(Vertice compare)
	{
		double[] coords = compare.getCoordinates();
		return (near(x, coords[0], .001) && near(y, coords[1], .001)  && near(z, coords[2], .001));
	}

	public boolean near(double num1, double num2, double tolerance)
	{
		return Math.abs(num1 - num2) <= tolerance;
	}
	
	public void round(int digits)
	{
		Vector3 convert = new Vector3(x, y, z);
		setCoordinates(convert.round(digits).getCoordinates());
	}
	
	public String toString()
	{
		return x + ", " + y + ", " + z;
	}
}