package designpattern.iteratorPattern;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:16 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Runner {
    public static void main(String[] args) {
        ProductList productList = new ProductList();
        productList.add(new ProductA());
        productList.add(new ProductB());
        productList.add(new ProductA());

        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            System.out.println(product.getMessage());
        }
    }
}
