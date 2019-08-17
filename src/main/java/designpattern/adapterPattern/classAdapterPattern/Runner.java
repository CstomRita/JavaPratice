package designpattern.adapterPattern.classAdapterPattern;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:04 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Runner {
    public static void main(String[] args) {
        Target target = new Adapter();
        System.out.println(target.getMessage());
    }
}
