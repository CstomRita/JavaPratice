package designpattern.abstractFactoryMethod;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:01 2019-04-05
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public abstract class ProductAll  {
    private Item1 item1;
    private Item2 item2;

    public Item1 getItem1() {
        return item1;
    }

    public void setItem1(Item1 item1) {
        this.item1 = item1;
    }

    public Item2 getItem2() {
        return item2;
    }

    public void setItem2(Item2 item2) {
        this.item2 = item2;
    }
}
