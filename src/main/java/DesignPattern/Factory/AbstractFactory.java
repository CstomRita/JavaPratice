package DesignPattern.Factory;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午8:34 2018/10/14
 * @ Description：抽象工厂方法
 * @ Modified By：
 * @Version: $
 */

import org.junit.Test;

/**
 * 工厂方法 和 抽象工厂
 *
 * 只有一个类和类的操作方法时 工厂方法
 *
 * 多个零件，每个零件有自己的具体实现，零件之间有依赖的问题 A1 B1 一个系列这样的
 *
 * 多个类和各自的实现方法——抽象工厂
 *
 * 抽象工厂是提供一系列相关和互相依赖对象的接口，无需关系具体的实现类只需要关注接口
 *
 * 抽象工厂的作用是将抽象零件组装为抽象产品
 *
 * AbstractProductA : ProductA1 ProductA2
 *
 * AbstractProductB : ProductB1 ProductB2
 *
 * AbstractProductA和AbstractProductB两个抽象产品，说他们是抽象产品是因为在各自下面还有不同的实现
 * 他们相当于两个零件，创建一个产品需要创建出所有的零件
 * 其中A1 B1是一个系列，A2 B2是一个系列
 *
 *
 */

// 1 抽象类，有自己的子类不同的实现
abstract class AbstractProductA {

}
class ProductA1 extends AbstractProductA{
    public ProductA1(){}
}
class ProductA2 extends AbstractProductA{
    public ProductA2(){}
}

abstract class AbstractProductB {

}
class ProductB1 extends AbstractProductB{
    public ProductB1(){}
}
class ProductB2 extends AbstractProductB{
    public ProductB2(){}
}

// 2 创建一个接口，提供所有零件（抽象产品）的创建方法
interface AbstractProductFactory{
    public AbstractProductA getInstanceA();
    public AbstractProductB getInstanceB();
}

// 3 创建具体的实现工厂,实现工厂间按照系列来分，具体一个实现工厂创建一个系列的零件
class ProductFactory1 implements AbstractProductFactory{

    public AbstractProductA getInstanceA() {
        return new ProductA1();
    }

    public AbstractProductB getInstanceB() {
        return new ProductB1();
    }
}
class ProductFactory2 implements AbstractProductFactory{

    public AbstractProductA getInstanceA() {
        return new ProductA2();
    }

    public AbstractProductB getInstanceB() {
        return new ProductB2();
    }
}
public class AbstractFactory {
    //4 调用时其实和工厂方法一样，创建一个指向具体工厂实现类的接口变量
    //5 区别在于实例化了多个对象
    @Test
    public void test() {
        AbstractProductFactory abstractProductFactory = new ProductFactory2();
        AbstractProductA abstractProductA = abstractProductFactory.getInstanceA();
        AbstractProductB abstractProductB = abstractProductFactory.getInstanceB();
        System.out.println(abstractProductA.getClass());
        System.out.println(abstractProductB.getClass());
    }
}
