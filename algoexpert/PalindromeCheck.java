package algoexpert;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        return new StringBuilder(str).reverse().toString().equalsIgnoreCase(str);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("churuhc"));
    }
}
