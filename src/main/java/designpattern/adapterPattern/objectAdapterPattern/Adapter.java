package designpattern.adapterPattern.objectAdapterPattern;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:11 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Adapter extends Target {
    private Adaptee adaptee;
    Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    public void setAdaptee(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public String getMessage() {
        return this.adaptee.getAdapteeMessage();
    }

    @Override
    public String getMessage1() {
        return null;
    }

    @Override
    public String getMessage2() {
        return null;
    }
}
