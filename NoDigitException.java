/**
 * 
 * @author vanessa
 * exception thrown if no digit
 */

public class NoDigitException extends Exception{
	
	/**
	 * NoDigitException with default message
	 */
	
	public NoDigitException() {
		super("The password must contain at least one digit");
	}
	
	/**
	 * NoDigitException with custom message
	 * @param
	 */
	
	public NoDigitException(String string) {
		super(string);
	}

}
