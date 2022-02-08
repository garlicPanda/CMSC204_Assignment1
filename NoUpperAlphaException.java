/**
 * 
 * @author vanessa
 * exception thrown if no uppercase letter
 */
public class NoUpperAlphaException extends Exception{
	
	/**
	 * with default message
	 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
	
	/**
	 * with custom message
	 * @param
	 */
	
	public NoUpperAlphaException(String string) {
		super(string);
	}

}
