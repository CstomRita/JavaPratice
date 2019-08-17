package designpattern.adapterPattern.classAdapterPattern;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:01 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Adapter extends Adaptee implements Target   {
    @Override
    public String getMessage() {
        return getAdapteeMessage();
    }
}
