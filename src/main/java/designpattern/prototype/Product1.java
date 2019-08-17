package designpattern.prototype;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 18:26 2019-04-02
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Product1 implements Product {

    public final String s = "123";
    @Override
    public void use() {
        System.out.println("实现实例方法Product1");
    }

    /**
     * 调用clone()方法返回对象
     * @return
     */
    @Override
    public Product getClone() {
        Product p = null;
        try {
            p = (Product)this.clone(); //哪个对象执行a.getClone，这里就是执行 a.clone()
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
