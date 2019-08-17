package designpattern.prototype;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 18:33 2019-04-02
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Runner {
    public static void main(String[] args) {
//        Client client = new Client();
//        client.regist("product1",new Product1());
//        client.regist("product2",new Product1());
//        Product1 product = (Product1) client.getInstance("product2");
//        System.out.println(product.s);
        Thing thing1 = new Thing();
        Thing thing2 = thing1.clone();
        System.out.println(thing2.arrayList);
    }
}
