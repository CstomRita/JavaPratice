package designpattern.abstractFactoryMethod.factory;

import designpattern.abstractFactoryMethod.Item1;
import designpattern.abstractFactoryMethod.Item1A;
import designpattern.abstractFactoryMethod.Item2;
import designpattern.abstractFactoryMethod.Item2A;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:09 2019-04-05
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class FactoryA extends AbstractFactory {
    private Item1 item1 = new Item1A();
    private Item2 item2 = new Item2A();


    @Override
    Item1 generateItem1() {
        item1.setType();
        return item1;
    }

    @Override
    Item2 generateItem2() {
        item2.setType();
        return item2;
    }
}
