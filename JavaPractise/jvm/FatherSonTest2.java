package jvm;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/11
 *
 * 父类+子类的初始化顺序：
 *
 * 1.父类中静态成员变量
 * 2.父类中静态代码块
 * 3.子类中静态成员变量
 * 4.子类中静态代码块
 * 5.父类中普通成员变量
 * 6.父类中普通代码块
 * 7.父类构造函数
 * 8.子类中普通成员变量
 * 9.子类中普通代码块
 * 10.子类构造函数
 *
 */

class Father {
    public String fStr1 = "father1";
    protected String fStr2 = "father2";
    private String fStr3 = "father3";

    {
        System.out.println("Father common block be called");
    }

    static {
        System.out.println("Father static block be called");
    }

    public Father() {
        System.out.println("Father constructor be called");
    }

}


class Son extends Father{
    public String SStr1 = "Son1";
    protected String SStr2 = "Son2";
    private String SStr3 = "Son3";

    {
        System.out.println("Son common block be called");
    }

    static {
        System.out.println("Son static block be called");
    }

    public Son() {
        System.out.println("Son constructor be called");
    }

}


public class FatherSonTest2 {
    public static void main(String[] args) {
        new Son();
        System.out.println();
        new Son();
    }
}
