package designpattern.strategyPattern;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:11 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class StrategyA extends AbstractStrategy {
    @Override
    void print() {
        System.out.println("调用A的实现方法");
    }
}
