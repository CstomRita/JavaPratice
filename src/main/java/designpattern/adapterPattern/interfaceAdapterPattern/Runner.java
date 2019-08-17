package designpattern.adapterPattern.interfaceAdapterPattern;

import designpattern.adapterPattern.objectAdapterPattern.Adaptee;
import designpattern.adapterPattern.objectAdapterPattern.Target;

import java.util.ArrayList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:20 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Runner {
    public static void main(String[] args) {
        Target target = new Adapter1(new Adaptee());
        System.out.println(target.getMessage());

        Target target1 = new Adapter2(new ArrayList());
        System.out.println(target1.toString());
    }
}
