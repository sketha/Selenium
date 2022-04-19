package practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegularExpression {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("aaabb48c6fghi7");
        String output = "";
        while (m.find()) {
            output = output + "+" + m.group();
        }
        System.out.println("The expected Output:"+output.substring(1, output.length()));
    }
}