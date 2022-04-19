package practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dummy {
    public static void modifyString(String args){
        String s = args.toLowerCase();
        String FN = "";
        String LN = "";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        Arrays.sort(s.toCharArray());
        for (char c : s.toCharArray()) {
            if (!FN.contains(String.valueOf(c))) {
                FN=FN+String.valueOf(c);
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
                LN=LN+ IntStream.range(0, map.get(c)).mapToObj(index -> "" + c).collect(Collectors.joining());;
                int index=FN.indexOf(c);
                FN=FN.substring(0, index) + FN.substring(index + 1);
            }
        }
        System.out.println("The expected Output for the String: " + args + " ==> " + LN + FN);
    }

    public static void main(String[] args) {
        modifyString("prasad");
        modifyString("kumarketha");
        modifyString("assassination");

    }

}