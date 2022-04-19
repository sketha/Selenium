package algoexpert;

import java.util.TreeMap;

public class GenerateDocument {
    public static boolean generateDocument(String characters, String document) {
        if (document.length() > characters.length())
            return false;
        TreeMap<Character, Integer> characterMap = new TreeMap<>();
        for (char s : characters.toCharArray()) {
            if (characterMap.containsKey(s))
                characterMap.put(s, characterMap.get(s) + 1);
            else
                characterMap.put(s, 1);
        }
        TreeMap<Character, Integer> documentMap = new TreeMap<>();
        for (char s : document.toCharArray()) {
            if (documentMap.containsKey(s))
                documentMap.put(s, (documentMap.get(s)) + 1);
            else
                documentMap.put(s, 1);
        }
        Boolean flag = true;
        System.out.println("Character: " + characterMap);
        System.out.println("Document: " + documentMap);
        for (char c : documentMap.keySet()) {

            if (characterMap.containsKey(c)) {
                if (characterMap.get(c) >= documentMap.get(c)) {
                    flag = true;
                } else {
                    return false;
                }
            } else
                return false;

        }
        return flag;
    }

    public static void main(String[] args) {
        String characters = "helloworldO";
        String document = "hello wOrld";

        System.out.println("character length :" + characters.length());
        System.out.println("document length :" + document.length());

        System.out.println("status :" + generateDocument(characters, document));

    }
}
