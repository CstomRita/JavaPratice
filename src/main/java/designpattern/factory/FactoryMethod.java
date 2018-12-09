package designpattern.factory;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午8:00 2018/10/14
 * @ Description：工厂方法
 * @ Modified By：
 * @Version: $
 */

import org.junit.Test;

/**
 * 简单工厂 和 工厂方法
 * 简单工厂内包含了必要的逻辑判断，根据客户端的选择生成不同的实例对象
 * 但是如果想新增加一个实例对象，需要修改原来的工厂类中的逻辑判断部分的代码
 *
 * 违背了开放封闭原则
 *
 * 引入工厂方法，将逻辑判断的部分移出到客户端的部分
 * 1 工厂类定义一个创建对象的接口
 * 2 实际上创建实体的工厂类实现这个接口
 * 3 客户端调用的时候需要根据自己的业务逻辑判断出实现哪一个创建实体的工厂类
 *
 * 工厂方法：当创建一个新的类别的时候不必去修改原有的代码
 * 只需要添加一个新的工厂创建实例
 * 在客户端处修改即可
 *
 * 缺点在于每次增加一个产品需要增加一个工厂的类，增加了额外的开发量
 *
 */

class Student{

}
class StudentA extends Student{
    public StudentA(){

    }
}
class StudentB extends Student{
    public StudentB(){

    }
}
class StudentC extends Student{
    public StudentC() {

    }
}

// 1 定义一个工厂的接口 提供一个创建对象的方法

interface Factory{
    public Student getInstance();
}
// 2 创建多个工厂实体对象 返回不同的实例
class StudentAFactory implements Factory{
    public Student getInstance() {
        return new StudentA();
    }
}
class StudentBFactory implements Factory{
    public Student getInstance() {
        return new StudentB();
    }
}
class StudentCFactory implements Factory{
    public Student getInstance() {
        return new StudentC();
    }
}
public class FactoryMethod {
    // 3 客户端调用时只需要声明Factory接口时实例化不同的工厂实例
    // 调用各自的创建方法即可
    @Test
    public void test() {
        Factory factory = new StudentBFactory();
        Student student = factory.getInstance();
        System.out.println(student.getClass());
    }

}
