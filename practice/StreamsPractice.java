package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsPractice {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7, 7));

       List<Integer> mini = list.stream()
                .filter(p->p%2!=0)
                .map(p->p*2)
                .collect(Collectors.toList());
        System.out.println("even List :"+mini);
        System.out.println("actual List" + list);
    }
}
