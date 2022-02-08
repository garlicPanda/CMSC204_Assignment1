/**
 * 
 * @author vanessa
 * exception thrown if has more than 2 of the same character in sequence
 */
public class InvalidSequenceException extends Exception{
	
	/**
	 * InvalidaSequence Exception with default message
	 */
	
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}
	
	/**
	 * InvalidaSequence Exception with custom message
	 * @param
	 */
	
	public InvalidSequenceException(String string) {
		super(string);
	}
}
