package javaabc.proxy;

public class RedWineFactory implements SellWine {
    @Override
    public void sellWine(double price) {
        System.out.println("成功购买红酒，价格为：" + price + "元");
    }
}