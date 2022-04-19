package practice;

import java.util.Arrays;

class Anagram {
    public static void main(String[] args) {
        StringComparison("peek", "keep");
        StringComparison("arc", "car");
        StringComparison("state", "tatse");
        StringComparison("dusty", "study");
        StringComparison("monkey", "donkey");

    }
    public static void StringComparison(String args1, String args2) {

        char[] firstStrArr = args1.replace(" ", "").toCharArray();
        char[] secondStrArr = args2.replace(" ", "").toCharArray();

        Arrays.sort(firstStrArr);
        Arrays.sort(secondStrArr);

        String s = Arrays.equals(firstStrArr, secondStrArr) ? "The Strings form an practice.Anagram"
                : "The Strings do not form a practice.Anagram";
        System.out.println(s);

    }
}