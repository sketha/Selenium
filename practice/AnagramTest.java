package practice;

import java.util.HashMap;
import java.util.Map;

public class AnagramTest {
    public static void main(String[] args) {
        char[] firstArr = "study".toCharArray();
        char[] secondArr = "dusty".toCharArray();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < firstArr.length; i++) {
            if (map1.containsKey(firstArr[i]))
                map1.put(firstArr[i], map1.get(firstArr[i]) + 1);
            else
                map1.put(firstArr[i], 1);
            if (map2.containsKey(secondArr[i]))
                map2.put(secondArr[i], map2.get(secondArr[i]) + 1);
            else
                map2.put(secondArr[i], 1);
        }
       System.out.println(map1.equals(map2)?"The Strings are Anagrams":"The Strings are not Anagrams");

    }
}
