package practice;

import org.apache.commons.lang3.StringUtils;

import java.util.TreeMap;

class test {
    public static void main(String[] args) {
        /*String a = "aZYwks";
        int i = 0;
        String target = "";
        for (char c : a.toUpperCase().toCharArray())
            target = target + c + IntStream.range(0, i++).mapToObj(index -> "" + c).collect(Collectors.joining()).toLowerCase() + "-";
        System.out.println("The expected Output: " + target.substring(0, target.length() - 1));*/

        int rank[] =new int []{5,3,4,2,1};
        char seq[] = new char[]{'b','a','c','d','e'};
        TreeMap<Integer,Character> map = new TreeMap<>();
        for (int i=0;i<5;i++) {
            map.put(rank[i],seq[i]);
        }
        System.out.println(map);
        System.out.println(StringUtils.join(map.values(),"-->"));


    }
}
