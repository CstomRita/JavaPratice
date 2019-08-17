package designpattern.bridgeMethod.functionLevel;

import designpattern.bridgeMethod.implementationLevel.ProductImpl;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:53 2019-04-06
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class NewProduct extends Product {

    public NewProduct(ProductImpl productImpl) {
        super(productImpl);
    }

    public void newFuction() {
        System.out.println("这是新方法");
    }
}
