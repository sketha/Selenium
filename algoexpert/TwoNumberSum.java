package algoexpert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TwoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        int[] array1 = new int[2];
            int j=0;
            for (int i=0;i< array.length;i++) {
                int k = targetSum-array[i];
                if(IntStream.of(array).anyMatch(x -> x == k) && array[i]!=k){
                    array1[0]=k; array1[1]=array[i];
                    return array1;
                }
            }
            return new int[0];
    }
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum=10;
        System.out.println(Arrays.toString(twoNumberSum(array,targetSum)));

        int[] array2 = new int[]{4, 6, 1};
        int targetSum2=5;
        System.out.println(Arrays.toString(twoNumberSum(array2,targetSum2)));
    }
}
