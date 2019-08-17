package designpattern.abstractFactoryMethod;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:02 2019-04-05
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public abstract class Item1 {
    public String type;

    public abstract void setType();

    public String getMessage() {
        return "这是零件1"+"的"+type;
    }
}
