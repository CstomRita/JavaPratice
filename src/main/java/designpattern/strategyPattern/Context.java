package designpattern.strategyPattern;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:12 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Context {
    private AbstractStrategy abstractStrategy;

    public void setAbstractStrategy(AbstractStrategy abstractStrategy) {
        this.abstractStrategy = abstractStrategy;
    }

    public Context(AbstractStrategy abstractStrategy) {
        this.abstractStrategy = abstractStrategy;
    }

    public void contextPrint() {
        int i = 0;
        while (i < 2) {
            System.out.println("这是context的方法，首先循环2次");
            i++;
        }
        this.abstractStrategy.print();
        System.out.println("context方法结束");
    }
}
