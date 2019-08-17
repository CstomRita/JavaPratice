package designpattern.bridgeMethod.functionLevel;

import designpattern.bridgeMethod.implementationLevel.ProductImpl;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:51 2019-04-06
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Product  {
    private ProductImpl productImpl;

    public Product(ProductImpl productImpl) {
        this.productImpl = productImpl;
    }
    public String getMessage() {
        return this.productImpl.getMessage();
    }
}
