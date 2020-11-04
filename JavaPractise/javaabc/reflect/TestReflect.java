package javaabc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/31
 */

class SmallPineapple {
    public String name;
    public int age;
    // 私有的
    private double weight;

    public SmallPineapple() {
    }

    public SmallPineapple(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void getInfo() {
        System.out.print("[" + name + " 的年龄是" + age + "]");
    }
}

public class TestReflect {
    public Map<Integer, Integer> getMap(String className) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName(className);
        Constructor con = clazz.getConstructor();
        return (Map<Integer, Integer>) con.newInstance();
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //注意这里必须是全类名路径，不能只是HashMap
        //new TestReflect().getMap("java.util.HashMap");

        //1.测试获取Class对象的三种方法
        Class clazz1 = SmallPineapple.class;//方法1：类名.class   这种方法只能获取在编译前已经声明了的类型
        SmallPineapple instance = new SmallPineapple();
        Class clazz2 = instance.getClass();//方法2：实例.getClass()
        Class clazz3 = Class.forName("javaabc.reflect.SmallPineapple");//方法3：通过类的全限定名获取类对象
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);


        //2.测试实例化类对象的两种方法
        //方法一：调用Class对象的newInstance方法，这个只能调用默认的无参构造器
        Class clazz = Class.forName("javaabc.reflect.SmallPineapple");
        SmallPineapple sp1 = (SmallPineapple) clazz.newInstance();

        //方法二：调用Constructor对象的newInstance方法，这个可以使用有参构造器
        Constructor con = clazz.getConstructor(String.class, int.class);
        con.setAccessible(true);
        SmallPineapple sp2 = (SmallPineapple) con.newInstance("fk", 10);

        //3.测试属性
        //获取public的，包括继承
        Field[] fields1 = clazz.getFields();
        //获取所有的，不包括继承的
        Field[] fields2 = clazz.getDeclaredFields();
        //用set去重
        Set<Field> allFields = new HashSet<>();
        allFields.addAll(Arrays.asList(fields1));
        allFields.addAll(Arrays.asList(fields2));

    }
}
