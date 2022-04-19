package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentMarks {
    public static void main(String[] args) {
      String[] studentArr = new String[]{"Sunil-56-88-23","Bindu-88-70-10","John-70-49-65","Thiara-99-99-99"};
        HashMap<String,Integer> map = new HashMap<>();

        Pattern numberPattern = Pattern.compile("\\d+");

        for (String studentProfile:Arrays.asList(studentArr)){
            int totalMarks=0;
            Matcher m1 = numberPattern.matcher(studentProfile);
            while(m1.find()){
            totalMarks=totalMarks+Integer.parseInt(m1.group());
            }
            map.put(studentProfile.substring(0,studentProfile.indexOf('-')),totalMarks);
            totalMarks=0;
        }
        System.out.println("Students with their Marks :"+map);
        Optional<Map.Entry<String,Integer>> finalValue = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        System.out.println("Higest Marks secured By: "+finalValue.get().getKey()+" ==> "+finalValue.get().getValue());


        ;
    }
}
