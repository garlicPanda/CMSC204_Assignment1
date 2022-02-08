/**
 * 
 * @author vanessa
 * exception thrown if no special character
 */

public class NoSpecialCharacterException extends Exception{
	
	/**
	 * with default message
	 */
	
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
	
	/**
	 * with custom message
	 * @param
	 */
	public NoSpecialCharacterException(String string) {
		super(string);
	}

}
