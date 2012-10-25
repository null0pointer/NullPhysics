package math;

public class Vector3 {
	
	/**
	 * The x, y, and z components of the vector.
	 */
	public	double	x;
	public	double	y;
	public	double	z;
	
	/**
	 * The magnitude of the vector.
	 */
	private	double	magnitude;
	
	/**
	 * Whether the magnitude is out of date.
	 */
	private	boolean	updateMagnitude;
	
	/**
	 * Whether the vector has a magnitude of 1.
	 */
	private boolean isUnitVector;
	
	
	/**
	 * Constructs a new Vector3 object.
	 * @param x The x component of the new vector.
	 * @param y The y component of the new vector.
	 * @param z The z component of the new vector.
	 */
	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
		updateMagnitude = true;
		isUnitVector = false;
	}
	
	/**
	 * Calculates the magnitude to the receiving vector.
	 * @return The magnitude of the receiving vector.
	 */
	public double magnitude() {
		if (updateMagnitude) {
			magnitude = Math.sqrt((x * x) + (y * y) + (z * z));
			updateMagnitude = false;
		}
		return magnitude;
	}
	
	/**
	 * Converts the reveiving vector to a unit vector (ie. A vector of unit magnitude).
	 */
	public void normalize() {
		if (!isUnitVector) {
			x /= magnitude();
			y /= magnitude();
			z /= magnitude();
			
			isUnitVector = true;
		}
		
		magnitude = 1;
		updateMagnitude = false;
	}
	
	/**
	 * Adds the argument vector to the reveiving vector.
	 * @param vector The argument vector.
	 */
	public void add(Vector3 vector) {
		x += vector.x;
		y += vector.y;
		z += vector.z;
		
		updateMagnitude = true;
		isUnitVector = false;
	}
	
	/**
	 * Subtracts the argument vector from the receiving vector.
	 * @param vector The argument vector.
	 */
	public void subtract(Vector3 vector) {
		x -= vector.x;
		y -= vector.y;
		z -= vector.z;
		
		updateMagnitude = true;
		isUnitVector = false;
	}
	
	/**
	 * Multiplies the magnitude of the receiving vector by the argument.
	 * @param factor The amount the receiving vector is multiplied by.
	 */
	public void multiply(double factor) {
		x *= factor;
		y *= factor;
		z *= factor;
		magnitude *= factor;
		
		isUnitVector = false;
	}
	
	/**
	 * Computes the dot product of the receiving vector and the argument vector.
	 * @param vector The argument vector.
	 * @return The value of the dot product.
	 */
	public double dot(Vector3 vector) {
		return (x * vector.x) + (y * vector.y) + (z * vector.z); 
	}
	
	/**
	 * Computes the cross product of the receiving vector by the argument vector (ie. (receiver) X (argument) ).
	 * @param vector The argument vector.
	 * @return The cross product vector.
	 */
	public Vector3 cross(Vector3 vector) {
		double newX = (y * vector.z) - (vector.y * z);
		double newY = (z * vector.x) - (vector.z * x);
		double newZ = (x * vector.y) - (vector.x * y);
		return new Vector3(newX, newY, newZ);
	}

	/**
	 * Generates a string representation of the receiving vector.
	 */
	public String toString() {
		return "{" + x + ", " + y + ", " + z + "}";
	}
	
}
