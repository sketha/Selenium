package algoexpert;

import java.util.TreeSet;

public class FirstDuplicateValue {
    public static int firstDuplicateValue(int[] array) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i :array){
            if(set.contains(i)){
                return i;
            }
            else
                set.add(i);
        }
        return -1;
    }
    public static void main(String[] args) {
       int[] array = new int[]{2,3,4,2,3,7,6,9};
       System.out.println(firstDuplicateValue(array));

    }
}

