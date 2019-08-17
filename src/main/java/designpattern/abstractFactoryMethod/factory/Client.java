package designpattern.abstractFactoryMethod.factory;

import designpattern.abstractFactoryMethod.Item1;
import designpattern.abstractFactoryMethod.Item2;
import designpattern.abstractFactoryMethod.ProductAll;
import designpattern.builderMethod.Product;
import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:14 2019-04-05
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Client {
    private AbstractFactory abstractFactory;

    @Test
    public void getProduct() {
        abstractFactory = new FactoryB();
        Item1 item1 = abstractFactory.generateItem1();
        Item2 item2 = abstractFactory.generateItem2();

    }
}
