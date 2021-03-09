package javaabc.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/11/14
 */

public class StreamDemo {
    public static void main(String[] args) {
        List<String> nameStrs = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");

        List<String> list = nameStrs.stream()
                .filter(s -> s.startsWith("L"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list);


        List<String> l = Arrays.asList("1", "1", "1", "2", "3", "3", "4", "5");
        Map<String, Long> map = l.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.forEach((k, v) -> {
            System.out.println("k = " + k + ", v = " + v);
        });
    }
}
