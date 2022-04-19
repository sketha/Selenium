package algoexpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a stream of characters (e.g. acacabcatghhellomvnsdb) and
 * a list of words (e.g. ["aca","cat","hello","world"] )
 * find and display count of each and every word once the stream ends.
 * (Like : "aca" : 2 , "cat" : 1 , "hello" : 1 , "world" : 0 )
 */
public class test {

    public static void main(String[] args) {
        System.out.println(wordCount("acacabcatghhellomvnsdb", new String[]{"aca", "cat", "hello", "world"}));
    }

    public static Map<String, Integer> wordCount(String stream, String[] words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String w : words) counts.put(w, 0);
        System.out.println(counts);
        List<Integer> wordLengths = counts.keySet().stream().map(key -> key.length()).distinct().sorted().collect(Collectors.toList());
        System.out.println(wordLengths);
        char[] chars = stream.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!checkChars(chars, counts, wordLengths, i)) break;
        }
        return counts;
    }

    private static boolean checkChars(char[] stream, Map<String, Integer> counts, List<Integer> wordLengths, int begin) {
        for (int length : wordLengths) {
            int end = length + begin;
            if (end > stream.length) {
                return false;
            } else {
                char[] temp = Arrays.copyOfRange(stream, begin, end);
                String part = String.valueOf(temp);
                if (counts.containsKey(part)) {
                    counts.put(part, counts.get(part) + 1);
                }
            }
        }
        return true;
    }
}
