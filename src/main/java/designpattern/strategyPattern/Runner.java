package designpattern.strategyPattern;

import java.util.ArrayList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:19 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Runner {

    public static void main(String[] args) {
        Context context = new Context(new StrategyA());
        context.contextPrint();

        // 替换策略
        context.setAbstractStrategy(new StrategyB());
        context.contextPrint();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.iterator();
    }
}
