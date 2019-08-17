package designpattern.adapterPattern.objectAdapterPattern;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:12 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Runner {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        System.out.println(target.getMessage());
    }
}
