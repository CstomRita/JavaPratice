package designpattern.factory;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午7:24 2018/10/14
 * @ Description：简单工厂模式
 * @ Modified By：
 * @Version: $
 */

/**
 * 简单工厂：
 * 1 创建一个工厂类的静态方法
 * 2 根据不同的条件返回一个父类或接口的变量指向不同的实例对象
 * 3 这些实例对象继承一个父类或接口
 */
class Operation{

}
class OperationA extends Operation{
    public OperationA(){

    }
}
class OperationB extends Operation{
    public OperationB(){

    }
}
class OperationC extends Operation{
    public OperationC(){

    }
}
public class OperationFactory {

    public static Operation getInstance(Class clazz) {
        Operation operation = null;
       if(clazz == OperationA.class) {
                operation = new OperationA();
            }
//            case OperationB.class: {
//                operation = new OperationB();
//                break;
//            }
//            case OperationC.class: {
//                operation = new OperationC();
//                break;
//            }
        return operation;
    }

    public static void main(String[] args) {
        Operation operation = OperationFactory.getInstance(OperationA.class);
        System.out.println(operation.getClass());
    }
}
