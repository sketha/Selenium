package practice;



import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class StudentMarks3 {
    public static void main(String[] args) {
        List<String> inputList = List.of("sunil-56-88-23", "bindul-88-70-10", "john-70-49-65");
        final var name = getStudentNameWithMaximumMarks(inputList);
        System.out.println(name);
    }


    private static String getStudentNameWithMaximumMarks(List<String> inputList) {
        return inputList
                .stream()
                .map(StudentMarks3::getNameAndTotal)
                .max(Comparator.comparing(s -> s.split("-")[1]))
                .orElse("DefaultName");
    }


    private static String getNameAndTotal(String s) {
        final var elements = s.split("-");
        final var sum = IntStream
                .range(1, elements.length)
                .mapToObj(operand -> Integer.parseInt(elements[operand]))
                .reduce(Integer::sum)
                .orElse(0);
        return elements[0] + "-" + sum;
    }

}
