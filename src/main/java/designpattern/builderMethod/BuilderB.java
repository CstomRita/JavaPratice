package designpattern.builderMethod;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:03 2019-04-04
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class BuilderB extends Builder {
    @Override
    public void buildFood(Product product) {
        product.setFood("汉堡");
    }

    @Override
    public void buildDrink(Product product) {
        product.setDrink("可乐");
    }

    @Override
    public void buildSnack(Product product) {
        product.setSnack("鸡米花");
    }
}
