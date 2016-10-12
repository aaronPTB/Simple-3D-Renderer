public class QuaternionRotator
{
	//Returns a rotated vector by a given angle
	public static Vector3 rotate(Vector3 vector, Vector3 axis, double angle)
	{
		//returns x, y, z as index 0, 1, 2
		double[] axisC = axis.getCoordinates();

		//converting the axis to a quaternion with which I can perform a vector rotation
		double x0 = 1        * Math.cos(angle/2);
		double x1 = axisC[0] * Math.sin(angle/2);
		double x2 = axisC[1] * Math.sin(angle/2);
		double x3 = axisC[2] * Math.sin(angle/2);

		Quaternion rotateAxis = new Quaternion(x0, x1, x2, x3);
		Quaternion rotateUndo = rotateAxis.conjugate();

		//converting the vector to be transformed to a quaternion
		double[] axisV = vector.getCoordinates();

		double y0 = 0;
		double y1 = axisV[0];
		double y2 = axisV[1];
		double y3 = axisV[2];

		Quaternion vectorT = new Quaternion(y0, y1, y2, y3);

		//rotates the vector following v' = qvq'
		Quaternion protoVector = rotateAxis.times(vectorT);
		Quaternion finalVector = protoVector.times(rotateUndo);
		return finalVector.getComponents();
	}
}