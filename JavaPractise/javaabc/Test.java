package javaabc;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */

public class Test {
    public static void main(String[] args) {
//        Integer a = 127;
//        Integer b = new Integer(127);
//        Integer c = 127;
//        int d = 127;
//        Integer e = Integer.valueOf(127);
//
//        System.out.println(a == b);//false
//        System.out.println(a == c);//true
//        System.out.println(b == c);//false
//        System.out.println(a == e);//true
//        System.out.println(b == e);//false
//
//        System.out.println(a.equals(b));//true
//        System.out.println(a.equals(c));//true
//
//        System.out.println(a == d);//true
//        System.out.println(b == d);//true
//        System.out.println(c == d);//true

//        Integer a = 1024;
//        Integer b = new Integer(1024);
//        Integer c = 1024;
//        int d = 1024;
//        Integer e = Integer.valueOf(1024);
//
//        System.out.println(a == b);//false
//        System.out.println(a == c);//false
//        System.out.println(b == c);//false
//        System.out.println(a == e);//false
//        System.out.println(b == e);//false
//
//        System.out.println(a.equals(b));//true
//        System.out.println(a.equals(c));//true
//
//        System.out.println(a == d);//true
//        System.out.println(b == d);//true
//        System.out.println(c == d);//true

//        String s1 = "string";
//        String s2 = "string";
//        String s3 = new String("string");
//        String s4 = String.valueOf("string");
//
//        System.out.println(s1 == s2);//true
//        System.out.println(s1 == s3);//false
//        System.out.println(s1 == s4);//true
//
//        System.out.println(s1.equals(s2));//true
//        System.out.println(s1.equals(s3));//true

//        String s1 = "string";
//        String s2 = "str" + "ing";
//        String s3 = new String("str") + new String("ing");
//        String s4 = "str";
//        String s5 = "ing";
//        String s6 = s4 + s5;
//        String s7 = s4 + "ing";
//        String s8 = "str" + s5;
//        String s9 = s8.intern();
//
//        System.out.println(s1 == s2);//true
//        System.out.println(s1 == s3);//false
//        System.out.println(s1 == s6);//false
//        System.out.println(s3 == s6);//false
//        System.out.println(s7 == s1);//false
//        System.out.println(s8 == s1);//false
//        System.out.println(s3 == s7);//false
//        System.out.println(s3 == s8);//false
//        System.out.println(s1 == s9);//true

//        String s1 = "a";
//        String s2 = "b";
//        String s3 = "a" + "b";
//        String s4 = s1 + s2;
//        System.out.println(s3 == s4);//false
//
//        final String s5 = "a";
//        final String s6 = "b";
//        String s7 = "a" + "b";
//        String s8 = s1 + s2;
//        System.out.println(s7 == s8);//false

        int a = 10;
        int b = 10;
        System.out.println(a == b);//true

        String s1 = "string";
        String s2 = "string";
        System.out.println(s1 == s2);//true
        System.out.println(s1.equals(s2));//true




    }
}
