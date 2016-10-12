public class RotateTest
{
	public static void main(String[] args)
	{
		Vector3 testObject = new Vector3(0,0,5);
	//	System.out.println(testObject);
		
	//	System.out.println(" ");
		
	//	testObject.rotate(new Vector3(0,1,0), Math.PI/2);
	  	System.out.println(testObject.rotate(new Vector3(0,1,0), Math.PI/2).getAngle(new Vector3(0,0,1)));
	}
}