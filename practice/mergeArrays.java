package practice;

import java.util.Arrays;
import java.util.stream.Stream;

public class mergeArrays {
    public static void main(String[] args) {
        String a[]= {"a","c","z"}; String b[]= {"b","f","z"};
       Object[] temp = Stream.of(a,b).flatMap(Stream::of).sorted().limit(3).toArray();
       // List<String> output = List.of(a,b).stream().distinct().sorted().findFirst().collect(Collectors.toList());
        System.out.println("The expected Output :"+Arrays.toString(temp));




    }
}
