/**
 * 
 * @author vanessa
 * utility class to check a password if valid, weak, or invalid
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	
	/**
	 * Checks if password meets all requirements
	 * @param password 
	 * @return true if password is valid
	 * @throws LengthException, NoUpperAlphaException, NoLowerAlphaException, 
	 *         NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	 */
	
	public static boolean isValidPassword(String password) throws LengthException, 
	                      NoUpperAlphaException, NoLowerAlphaException, NoDigitException, 
	                      NoSpecialCharacterException, InvalidSequenceException  {
		isValidLength(password);
		hasUpperAlpha(password);
		hasLowerAlpha(password);
		hasDigit(password);
		hasSpecialChar(password);
		NoSameCharInSequence​(password);
		
		return true;
	}
	
	/**
	 * Checks if password is weak
	 * @return false if password is not weak
	 * @throws WeakPasswordException t
	 */
	
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		boolean valid = false;
		try {
			valid = isValidPassword(password);
		}catch (Exception e){
			return false;
		}
		if(valid && hasBetweenSixAndNineChars(password)){
			throw new WeakPasswordException();
		}		
		return false;
	}
	
	/**
	 * checks if an arraylist of passwords are valid 
	 * @param password 
	 * @return invalidPasswords an arraylist of invalid passwords with the reason
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> password){
		ArrayList<String> output = new ArrayList<String>();
		for (String s : password) {
			try {
				isValidPassword(s);
			}
			catch(LengthException e) {
				output.add(s+" -> "+e.getMessage());
			}
			catch(NoUpperAlphaException e) {
				output.add(s+" -> "+e.getMessage());
			}
			catch(NoLowerAlphaException e) {
				output.add(s+" -> "+e.getMessage());
			}
			catch(NoDigitException e) {
				output.add(s+" -> "+e.getMessage());
			}
			catch(NoSpecialCharacterException e) {
				output.add(s+" -> "+e.getMessage());
			}
			catch(InvalidSequenceException e) {
				output.add(s+" -> "+e.getMessage());
			}
		}
		return output;
	}
	
	/**
	 * Compares two passwords
	 * @param password 
	 * @param passwordConfirm 
	 * @throws UnmatchedException 
	 */
	
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}
	
	/**
	 * Compares passwords
	 * @param password 
	 * @param passwordConfirm 
	 * @return true if both same password 
	 */
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	
	/**
	 * Checks if password length is between 6 and 9 characters
	 * @param password 
	 * @return true if password has 6 to 9 characters
	 */
	
	public static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() >= 6 && password.length() <= 9) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	/**
	 * Checks if password at least 1 digit
	 * @param password 
	 * @return true if has a digit
	 * @throws NoDigitException 
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(password);
		if(matcher.find()) {
			
			return true;
		}
		throw new NoDigitException();

	}
	
	/**
	 * Checks if password at least 1 lowercase character
	 * @param password 
	 * @return true if has a lowercase character
	 * @throws NoLowerAlphaException 
	 */
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		
		Pattern pattern = Pattern.compile("[a-z]");
		Matcher matcher = pattern.matcher(password);
		if(matcher.find()) {
			
			return true;
		}
		
		throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
	}
	
	/**
	 * Checks if password at least 1 uppercase character
	 * @param password 
	 * @return true if has a uppercase character
	 * @throws NoUpperAlphaException 
	 */
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(password);
		if(matcher.find()) {
			
			return true;

		}
		throw new NoUpperAlphaException();
	}
	
	/**
	 * No more than 2 of the same character in a sequence 
	 * @param password 
	 * @return true if it do not have more than two in a sequence
	 * @throws  InvalidSequenceException 
	 */
	
	public static boolean NoSameCharInSequence​(String password) throws InvalidSequenceException{
		
		boolean Two = false;
		
		for(int i = 1;i<password.length();i++) {
			
			if(Two)
				if(password.charAt(i-1) == password.charAt(i)) {
					throw new InvalidSequenceException();
				}
				else {
					Two = false;
				}

			if(password.charAt(i-1) ==password.charAt(i))
				Two = true;

		}
		
		return true;
	}
	
	/**
	 * Checks if password contains at least 1 special character
	 * @param password the string to be checked for special characters
	 * @return true if it contains at least 1 special character
	 * @throws NoSpecialCharacterException throws if it doesn't meet special character requirement
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(password);
		if(matcher.find()) {
			return true;

		}
		throw new NoSpecialCharacterException("The password must contain at least one special character");
		
	}
	
	/**
	 * Checks if password at least 6 characters
	 * @param password the string to be checked for length
	 * @return true if string has at least 6 characters
	 * @throws LengthException throws if it doesn't meet length requirements
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length() >= 6) {
			return true;
		}
		else {
			throw new LengthException();
		}
	}
	/**
	 * work cited
	 * 1.https://www.appsdeveloperblog.com/encrypt-user-password-example-java/
	 * 2.https://stackoverflow.com/questions/58035410/java-junit-expected-exception-to-be-thrown-but-nothing-is-thrown
	 * 3.https://stackoverflow.com/questions/13674449/checking-password-code
	 * 4.https://www.geeksforgeeks.org/program-to-check-the-validity-of-a-password/
	 * 5.https://coderanch.com/t/560726/java/Check-Password-Program
	 */
}
