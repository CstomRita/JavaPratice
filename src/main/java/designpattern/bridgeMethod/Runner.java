package designpattern.bridgeMethod;

import designpattern.bridgeMethod.functionLevel.NewProduct;
import designpattern.bridgeMethod.functionLevel.Product;
import designpattern.bridgeMethod.implementationLevel.ProductAImpl;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:54 2019-04-06
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Runner {
    public static void main(String[] args) {
        //创建了一个ProductA的Product实例
        // 可以调用ProductA的具体实现基本功能方法
        Product product = new Product(new ProductAImpl());
        System.out.println(product.getMessage());

        //创建了一个ProductA的NewProduct实例
        // 可以调用ProductA的具体实现基本功能方法 + newProduct的新方法
        NewProduct newProduct = new NewProduct(new ProductAImpl());
        System.out.println(newProduct.getMessage());
        newProduct.newFuction();
    }
}
