package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramMatch {
    public static void main(String[] args) {
        HashMap<String, List<String>> myMaps = new HashMap<>();
        List<String> list=new ArrayList<>(Arrays.asList("yo","act","flop","tac","foo","cat","oy","olfp"));

        for (String element : list) {
           char[] temp =element.toCharArray();
            Arrays.sort(temp);
            String sortedString = String.valueOf(temp);
            if (!myMaps.containsKey(sortedString))
                myMaps.put(sortedString, new ArrayList<String>());
            myMaps.get(sortedString).add(element);
        }
        System.out.println(myMaps.values());

    }
}
