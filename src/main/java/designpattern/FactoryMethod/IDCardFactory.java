package designpattern.FactoryMethod;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:04 2019-03-29
 * @ Description：子类工厂方法
 * @ Modified By：
 * @Version: $
 */
public class IDCardFactory extends ProductFactory{
    @Override
    protected Product createProduct(String user) {
        return new IDCard(user);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println("注册"+ ((IDCard)product).getUser()+"的信息");
    }
}
