package corejavaprograms;

public class sfsgsgsgd {
	public static Boolean validate(String password) {
		boolean uppercaseCheck = !password.equals(password.toLowerCase());
		boolean lowercaseCheck = !password.equals(password.toUpperCase());
		boolean passwordLength = password.length() >= 12;
		boolean subStringcheck = !password.contains("123");
		boolean digitCheck =false;
		char[] strArray = password.toLowerCase().toCharArray();
		for (char c : strArray) {
			boolean digitCheck1 = Character.isDigit(c);
			if(digitCheck1==true){
				digitCheck =digitCheck1;
				break;
			}
		}		
		if(uppercaseCheck && lowercaseCheck && passwordLength && subStringcheck && digitCheck){
			return true;}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(validate("Strong1Password")); // Strong password
		System.out.println(validate("strong1password")); // Weak password
	}
}