package java8Change;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:56 2019-05-06
 * @ Description：Java8中接口内的方法可以包含方法体，抽象方法还是必须empty body
 * @ Modified By：
 * @Version: $
 */
public interface InterfaceChange {
    public default void defalutmethod(){
        System.out.println("defalutmethod");
    }

    public static void staticMethod(){
        System.out.println("staticMethod");
    }

    void mthod();

    class InterfaceIml implements InterfaceChange{

        @Override
        public void mthod() {
        }
    }

    public static void main(String[] args) {
        InterfaceChange.staticMethod();

        InterfaceIml interfaceIml = new InterfaceIml();
        interfaceIml.defalutmethod();
    }
}
