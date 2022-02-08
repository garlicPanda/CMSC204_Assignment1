/**
 * 
 * @author vanessa
 * exception thrown if no lowercase letter
 */
public class NoLowerAlphaException extends Exception{
	
	/**
	 * with default message
	 */
	
	public NoLowerAlphaException() {
		
		super("The password must contain at least one lowercase alphabetic character");
	}
	
	/**
	 * with custom message
	 * @param
	 */
	
	public NoLowerAlphaException(String string) {
		super(string);
	}

}
