/**
 * 
 * @author vanessa
 * exception thrown if password does not match
 */
public class UnmatchedException extends Exception{
	
	/**
	 * with default message
	 */
	
	public UnmatchedException() {
		super("Passwords do not match");
	}
	
	/**
	 * with custom message
	 * @param
	 */
	
	public UnmatchedException(String string) {
		super(string);
	}

}
