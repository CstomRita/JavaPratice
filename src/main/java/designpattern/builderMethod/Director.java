package designpattern.builderMethod;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:04 2019-04-04
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Director {
    private Builder builder;
    private Product product;
    Director(Builder builder) {
        this.builder = builder;
        this.product = new Product();
    }

    public Product getProduct() {
        builder.buildDrink(this.product);
        builder.buildSnack(this.product);
        builder.buildFood(this.product);
        return this.product;
    }
}
