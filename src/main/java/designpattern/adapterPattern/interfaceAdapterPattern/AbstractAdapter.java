package designpattern.adapterPattern.interfaceAdapterPattern;

import designpattern.adapterPattern.objectAdapterPattern.Target;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:16 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public abstract class AbstractAdapter extends Target {
    @Override
    public String getMessage1() {
        return null;
    }

    @Override
    public String getMessage2() {
        return null;
    }
}
