import java.lang.Math;

public class Vector3
{
	private double x, y, z;

	//creates a vector given an x, y, z coordinate
	public Vector3(double x_set, double y_set, double z_set)
	{
		x = x_set;
		y = y_set;
		z = z_set;
	}

	//creates a vector3 from 1 coordinate pair
	public Vector3(double[] location)
	{
		x = location[0];
		y = location[1];
		z = location[2];
	}

	//creates a vector pointing from >from to >to
	public Vector3(Vector3 from, Vector3 to)
	{
		x = to.getX() - from.getX();
		y = to.getY() - from.getY();
		z = to.getZ() - from.getZ();
	}

	//creates a vector from two xyz pairs
	public Vector3(double[] from, double[] to)
	{
		x = to[0] - from[0];
		y = to[1] - from[1];
		z = to[2] - from[2];
	}

	//returns x coordinate
	public double getX()
	{
		return x;
	}

	//returns y coordinate
	public double getY()
	{
		return y;
	}

	//returns z coordinate
	public double getZ()
	{
		return z;
	}

	//gets the coordinates that the vector points to and returns it as a table
	public double[] getCoordinates()
	{
		double[] coords = {x, y, z};
		return coords;
	}

	//sets the coordinates that the vector points to
	public void setCoordinates(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//sets the coordinates using a coordinate table
	public void setCoordinates(double[] coords)
	{
		x = coords[0];
		y = coords[1];
		z = coords[2];
	}

	//adds two vectors' coordinates
	public Vector3 plus(Vector3 otherVector)
	{
		double ax = x + otherVector.getX();
		double ay = y + otherVector.getY();
		double az = z + otherVector.getZ();

		return new Vector3(ax,ay,az);
	}

	//Given a vector, this converts 3d points into a screen position.
	/*public ScreenCoordinates transform()
	{
		return new ScreenCoordinates();
	}*/

	//prints x, y, z coordinates
	public String toString()
	{
		return x + ", " + y + ", " + z;
	}

	//returns the length of this vector
	public double length()
	{
		return Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
	}

	//takes this vector and normalizes it so that its unit length is 1
	public Vector3 unit()
	{
		double len = this.length();
		return new Vector3(x/len, y/len, z/len);
	}


	//takes the dot product of this vector and OtherVector
	public double dot(Vector3 otherVector)
	{
		return  (otherVector.getX() * x) + 
				(otherVector.getY() * y) + 
				(otherVector.getZ() * z);
	}

	//gets the angle between two vectors, and returns the answer in radians
	public double getAngle(Vector3 otherVector)
	{
		Vector3 normalizedThis        = this.unit();
		Vector3 normalizedOtherVector = otherVector.unit();

		return Math.acos(normalizedThis.dot(normalizedOtherVector));
	}

	//rotates a vector by a given angle around a certain axis
	public Vector3 rotate(Vector3 axis, double angle)
	{
		Vector3 vector = this;
		return QuaternionRotator.rotate(vector, axis, angle);
	}
	
	public Vector3 round(int digits)
	{
		double newX = Math.round(x * Math.pow(10,digits))/Math.pow(10,digits);
		double newY = Math.round(y * Math.pow(10,digits))/Math.pow(10,digits);
		double newZ = Math.round(z * Math.pow(10,digits))/Math.pow(10,digits);
		
		return new Vector3(newX, newY, newZ);
	}
}