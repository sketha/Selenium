package algoexpert;

public class FirstNonRepeatingCharacter {
    public static int firstNonRepeatingCharacter(String string) {
        for (char c:string.toLowerCase().toCharArray()) {
            if (string.indexOf(c) == string.lastIndexOf(c))
                return string.indexOf(c);
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("faadabcbbebdf"));
    }
}
