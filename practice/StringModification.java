package practice;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringModification {
    public static void modifyString(String args) {
        String input = args.toLowerCase();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        String FN = "";
        String LN = "";
        for (char s : map.keySet()) {
            if (map.get(s) > 1)
                FN = FN + IntStream.range(0, map.get(s)).mapToObj(index -> "" + s).collect(Collectors.joining());
            else
                LN = LN + IntStream.range(0, map.get(s)).mapToObj(index -> "" + s).collect(Collectors.joining());
        }
        System.out.println("The expected Output for the String: " + input + " ==> " + FN + LN);
    }
     public static void main(String[] args) {
        modifyString("prasad");
        modifyString("kumarketha");
         modifyString("assassination");
    }
}
