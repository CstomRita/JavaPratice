package designpattern.builderMethod;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:00 2019-04-04
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class BuilderA extends Builder{

    @Override
    public void buildFood(Product product) {
        product.setFood("鸡肉卷");
    }

    @Override
    public void buildDrink(Product product) {
        product.setDrink("果汁");
    }

    @Override
    public void buildSnack(Product product) {
        product.setSnack("薯条");
    }

}
