package practice;

import java.util.Arrays;
import java.util.List;

public class LengthOfSegment {
    public static int maxlength(List<Integer> arr) {

        long negativeNum = arr.stream().filter(a -> a < 0).count();
        long x = ((negativeNum % 2) == 0 && (negativeNum != 1)) ? negativeNum : negativeNum - 1;
        return (int) (x + arr.size() - negativeNum);
    }

    public static void main(String[] args) {
        List<Integer> segment1 = Arrays.asList(1, -2, -3, 4);
        System.out.println("Maximum length of the Segment: " + maxlength(segment1));

        List<Integer> segment2 = Arrays.asList(-3, 5);
        System.out.println("Maximum length of the Segment: " + maxlength(segment2));
    }
}
