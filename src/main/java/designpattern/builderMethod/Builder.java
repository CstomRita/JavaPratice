package designpattern.builderMethod;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 20:57 2019-04-04
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public abstract class Builder {

    public abstract void buildFood(Product product);
    public abstract void buildDrink(Product product);
    public abstract void buildSnack(Product product);

}
