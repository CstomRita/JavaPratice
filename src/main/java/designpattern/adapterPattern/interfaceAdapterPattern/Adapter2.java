package designpattern.adapterPattern.interfaceAdapterPattern;

import algorithm.offerAlgorithm.treeProblem.Print;
import designpattern.builderMethod.Product;

import java.util.ArrayList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:27 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Adapter2 extends AbstractAdapter {
    private ArrayList<Integer> arrayList;
    Adapter2(ArrayList arrayList) {
        this.arrayList = arrayList;
    }
    @Override
    public String getMessage() {
        return this.arrayList.toString();
    }
}
