package algoexpert;

import java.util.Arrays;

public class SortedArraySqaure {
    public static int[] sortedSquaredArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
           array[i]*=array[i];
        }
        Arrays.sort(array);
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-5, -4, -3, -2, -1};

        System.out.println(Arrays.toString(sortedSquaredArray(array)));

        String s="xyz";
        int k=2;
        char[] arr = s.toCharArray();
        for (char r:arr) {
            int i = k + (int) r;
            System.out.print((char)i);
        }
    }
}
