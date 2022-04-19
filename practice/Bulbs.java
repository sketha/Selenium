package practice;

public class Bulbs {
    public static String calculationOfSwitch(int k, String pattern) {
        char[] patternArr = pattern.toCharArray();
        for (int i = 0, j = i; j < k; j++) {
            if (patternArr[i] == 'O')
                patternArr[i] = 'X';
            else
                patternArr[i] = 'O';
            patternArr = realignString(String.valueOf(patternArr)).toCharArray();

            i = 0;
        }
        return String.valueOf(patternArr);
    }

    public static String realignString(String args) {
        StringBuilder modify = new StringBuilder(args);
        for (int i = 0; args.charAt(i) != 'O' && i < args.length() - 1; i++) {
            if (args.charAt(i) == 'X')
                modify.setCharAt(i + 1, args.charAt(i + 1) == 'X' ? 'O' : 'X');
            else
                modify.setCharAt(1, 'O');
            args = modify.toString();
        }
        return args.toString();
    }

    public static void main(String args[]) {

        System.out.println("Test case 1 : " + calculationOfSwitch(2, "OOXOX"));
        System.out.println("Test case 2 : " + calculationOfSwitch(2, "XOXXO"));
        System.out.println("Test case 3 : " + calculationOfSwitch(3, "XOXXO"));
        System.out.println("Test case 4 : " + calculationOfSwitch(200, "OXOX"));

    }
}

