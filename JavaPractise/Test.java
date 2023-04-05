import java.io.File;
import java.util.*;
import java.util.stream.IntStream;
import java.util.*;

public class Test {

//    public static void main(String[] args) {
//        System.out.println(getDivison("0081"));
//
//    }

    public static int getDivison(String s) {
        int ans = 0;
        char[] charArray = s.toCharArray();
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = charArray[i] - '0';
        }
        // 一个数所有数位数字之和能被3整除，这个数就能被3整除
        // 先求原始的和
        int sum = IntStream.of(intArray).sum();
        for (int i = 0; i < charArray.length; i++) {
            // 减去当前位的值
            int tempSum = sum - intArray[i];
            for (int j = 0; j <= 9; j++) {
                int newSum = tempSum + j;
                if (newSum % 3 == 0) {
                    ans++;
                }
            }
        }
        int len = s.length();
        // 如果原始和能被3整数，要减去多算的
        if (sum % 3 == 0) {
            ans = ans - len + 1;
        }
        return ans;
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        String s = "1";
        int[][] input = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ans = new Test().reconstructQueue(input);
        for (int[] e : ans) {
            System.out.println(Arrays.toString(e));
        }

//        String[] arr = {"1", "2"};
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add(0, "3");
//        System.out.println(list);
    }

}