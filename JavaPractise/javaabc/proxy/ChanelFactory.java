package javaabc.proxy;

public class ChanelFactory implements SellPerfume {
    @Override
    public void sellPerfume(double price) {
        System.out.println("成功购买香水，香水价格：" + price + "元");
    }
}