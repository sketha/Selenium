package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentMarks2 {
    public static void main(String[] args) {
        String[] studentArr = new String[] { "Sunil-56-88-23", "Bindu-88-70-10", "John-70-49-65", "Thiara-99-99-99" };

        Pattern numberPattern = Pattern.compile("\\d+");
        int totalMarks = 0;
        String name = "";
        for (String studentProfile : Arrays.asList(studentArr)) {
            int marks = 0;
            Matcher m1 = numberPattern.matcher(studentProfile);
            while (m1.find()) {
                marks = marks + Integer.parseInt(m1.group());
            }
            if (marks > totalMarks) {
                totalMarks = marks;
                name = studentProfile.substring(0, studentProfile.indexOf('-'));
            }
            marks = 0;
        }
        System.out.println("Higest Marks secured By: " + name + " ==> " + totalMarks);
    }
}
