package javaabc.stream;

import java.util.stream.IntStream;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/04/20
 */

public class DebugDemo {
    public static void main(String[] args){
        int[] result = IntStream.of(10,189,192,12,43,234,76,6763)
                .filter((element)->element>10)
                .map((element)->element*2)
                .distinct()
                .sorted()
                .toArray();
        int a = 1;
        int b = 2;
    }
}
