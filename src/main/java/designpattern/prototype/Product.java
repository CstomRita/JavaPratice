package designpattern.prototype;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 18:24 2019-04-02
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public interface Product extends Cloneable {
    public  abstract void use();
    public abstract Product getClone();
}
