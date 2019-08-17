package designpattern.FactoryMethod;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 20:55 2019-03-29
 * @ Description：父类工厂方法
 * @ Modified By：
 * @Version: $
 */
public abstract class ProductFactory {

    public final Product create(String user) {
        Product product = createProduct(user);
        registerProduct(product);
        return product;
    }

    protected abstract Product createProduct(String user);
    protected abstract void registerProduct(Product product);
}
