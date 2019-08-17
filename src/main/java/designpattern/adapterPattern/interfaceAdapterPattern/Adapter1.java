package designpattern.adapterPattern.interfaceAdapterPattern;

import designpattern.adapterPattern.objectAdapterPattern.Adaptee;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:18 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Adapter1 extends AbstractAdapter {
    private Adaptee adaptee;
    Adapter1(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    @Override
    public String getMessage() {
        return this.adaptee.getAdapteeMessage();
    }

}
