package designpattern.prototype;

import designpattern.TemplateMethod.runner.Run;
import org.junit.Test;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:19 2019-04-02
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Client implements Serializable {

    private HashMap<String,Product> hashMap = new HashMap<>();

    public void regist(String name,Product product) {
        this.hashMap.put(name,product);
    }

    public Product getInstance(String name) {
        Product p = hashMap.get(name);
        return p.getClone();
    }
}
