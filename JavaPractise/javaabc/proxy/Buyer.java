package javaabc.proxy;

import java.lang.reflect.Proxy;

public class Buyer {
    public static void main(String[] args) {
        ChanelFactory chanelFactory = new ChanelFactory();
        //初始化代理工厂
        SellProxyFactory sellProxyFactory = new SellProxyFactory(chanelFactory);

        //Proxy类的静态方法newProxyInstance方法
        SellPerfume sellPerfume = (SellPerfume)
                Proxy.newProxyInstance(chanelFactory.getClass().getClassLoader(),
                        chanelFactory.getClass().getInterfaces(),
                        sellProxyFactory);

        sellPerfume.sellPerfume(1999.99);


        //实例化一个红酒销售商
        RedWineFactory redWineFactory = new RedWineFactory();
        //实例化代理工厂，传入红酒销售商引用控制对其的访问
        SellProxyFactory sellProxyFactory1 = new SellProxyFactory(redWineFactory);

        //实例化代理对象，该对象可以售卖红酒
        SellWine sellWineProxy = (SellWine)
                Proxy.newProxyInstance(redWineFactory.getClass().getClassLoader(),
                        redWineFactory.getClass().getInterfaces(),
                        sellProxyFactory1);
        //代理售卖红酒
        sellWineProxy.sellWine(1999.99);

    }
}