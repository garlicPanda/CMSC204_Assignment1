/**
 * 
 * @author vanessa
 * exception thrown if shorter than 6 characters
 */

public class LengthException extends Exception{
	
	/**
	 * LengthException with default message
	 */
	
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
	
	/**
	 * LengthException with custom message
	 * @oaram
	 */
	
	public LengthException(String string) {
		super(string);
	}

}
