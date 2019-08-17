package designpattern.abstractFactoryMethod.factory;

import designpattern.abstractFactoryMethod.Item1;
import designpattern.abstractFactoryMethod.Item2;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:07 2019-04-05
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public abstract class AbstractFactory {
    abstract Item1 generateItem1();
    abstract Item2 generateItem2();
}
