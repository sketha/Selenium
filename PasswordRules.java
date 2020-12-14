package advancedUserInteractions;
public class PasswordRules {
	public static Boolean validate(String password) {
		boolean hasUppercase = !password.equals(password.toLowerCase());
		boolean hasLowercase = !password.equals(password.toUpperCase());
		boolean isAtLeast8   = password.length() >= 12;
		boolean subStringcheck = !password.contains("123");
		if(hasUppercase && hasLowercase && isAtLeast8 && subStringcheck){
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