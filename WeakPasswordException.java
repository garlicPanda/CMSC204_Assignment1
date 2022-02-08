/**
 * 
 * @author vanessa
 * exception thrown if is valid, but has 6-9 characters
 */
public class WeakPasswordException extends Exception{
	
	/**
	 * with default message
	 */
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}
	
	/**
	 * with custom message
	 * @param
	 */
	
	public WeakPasswordException(String string) {
		super(string);
	}

}
