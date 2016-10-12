public class ScreenCoordinate
{
	private int x;
	private int y;

	public ScreenCoordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	//returns x coordinate
	public int getX()
	{
		return x;
	}
	
	//returns y coordinate
	public int getY()
	{
		return y;
	}

	//takes a vector3 object position and converts it into screen coordinates using perspective
	public static ScreenCoordinate fromVector3(Vector3 objectPosition, Vector3 viewDirection, ScreenCoordinate screenSize, double fieldOfView)
	{
		Vector3 objectPositionXZ = new Vector3(objectPosition.getX(), 0, objectPosition.getZ());

		//finds the angles needed for the screen
		
		Vector3 newVD = viewDirection.rotate(new Vector3(0,1,0), Math.toRadians(-fieldOfView/2));
		Vector3 newXZ = objectPositionXZ.rotate(new Vector3(1,0,0), Math.toRadians(-fieldOfView/2));
		
		double angleX = Math.toDegrees(newVD.getAngle(objectPositionXZ));
		double angleY = Math.toDegrees(newXZ.getAngle(objectPosition));
		
		//corrects for difference in screen dimensions
		double fieldOfViewY = fieldOfView * screenSize.getY()/screenSize.getX();

		//takes angle and converts to screen position
		int foundX = (int) (angleX / fieldOfView  * screenSize.getX());
		int foundY = (int) (angleY / fieldOfViewY * screenSize.getY());

		return new ScreenCoordinate(foundX, foundY);
	}
}