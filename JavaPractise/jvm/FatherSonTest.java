package jvm;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/11
 */

class Father1 {
    int x = 10;

    public Father1() {
        this.print();
        x = 20;
    }
    public void print() {
        System.out.println("Father.x = " + x);
    }
}

class Son1 extends Father1 {
    int x= 30;
    public Son1() {
        this.print();
        x = 40;
    }
    @Override
    public void print() {
        System.out.println("Son.x = " + x);
    }
}


public class FatherSonTest {
    public static void main(String[] args) {
        Father1 f = new Son1();
        //Father1 f = new Father1();
        System.out.println(f.x);
    }
}
