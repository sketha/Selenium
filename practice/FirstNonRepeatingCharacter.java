package practice;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println("The first Non Repeating character of sdalfsfasfa --> " + nonRepeatingCharacter("sdalfsfasfa"));
        System.out.println("The first Non Repeating character of abababcababab --> " + nonRepeatingCharacter("abababcababab"));
        System.out.println("The first Non Repeating character of maheshbandimahesh --> " + nonRepeatingCharacter("maheshbandimahesh"));
        System.out.println("The first Non Repeating character of sunilkethasunil --> " + nonRepeatingCharacter("sunilkethasunil"));

    }

    public static char nonRepeatingCharacter(String args) {
        for (int i = 0; i < args.length(); i++) {
            if (args.indexOf(args.charAt(i)) == args.lastIndexOf(args.charAt(i)))
                return args.charAt(i);
        }
        return ' ';
    }
}
