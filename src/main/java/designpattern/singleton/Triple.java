package designpattern.singleton;

import algorithm.offerAlgorithm.treeProblem.TreeNode;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 11:34 2019-04-02
 * @ Description：只能生成三个实例，编号 0 1 2
 * 通过getInstance(i)获取第几个实例
 * @ Modified By：
 * @Version: $
 */
public class Triple {
    private static Triple[] triples;
    private static int size;
    private static Object o = new Object();
    public int number;

   static  {
        size = 3;
        triples = new Triple[size];
    }
    private Triple(int i) {
        this.number = i;
    }
    public static Triple getInstance(int i) {
        if (triples[i] == null) {
            synchronized (o) {
                if (triples[i] == null) {
                    triples[i] = new Triple(i);
                }
            }
        }
        return triples[i];
    }
}
