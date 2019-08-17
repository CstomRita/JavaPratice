package designpattern.FactoryMethod;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:08 2019-03-29
 * @ Description：runner
 * @ Modified By：
 * @Version: $
 */
public class Runner {
    public static void main(String[] args) {
        ProductFactory factory = new IDCardFactory();
        Product product1 = factory.create("小明");
        product1.use();
        Product product2 = factory.create("小红");
        product2.use();
    }
}
