package designpattern.abstractFactoryMethod.factory;

import designpattern.abstractFactoryMethod.*;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:14 2019-04-05
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class FactoryB extends AbstractFactory{
    private Item1 item1 = new Item1B();
    private Item2 item2 = new Item2B();


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
