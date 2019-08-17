package designpattern.iteratorPattern;

import java.util.ArrayList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:05 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class ProductList implements Iterable {
    // 1 一个list维护元素，提供基本add remove功能
    private ArrayList<Product> arrayList = new ArrayList<>();

    public void add(Product product) {
        arrayList.add(product);
    }
    public void remove(Product product) {
        arrayList.remove(product);
    }

    // 2 实现iterable接口
    @Override
    public Iterator iterator() {
        return new ProductListIterator();
    }

    // 3 内置iterator内部类
    private class ProductListIterator implements Iterator<Product>{
        int i = 0;
        @Override
        public boolean hasNext() {
            return i < arrayList.size();
        }

        @Override
        public Product next() {
            if (i >= arrayList.size()) {
                return null;
            }
            Product p = arrayList.get(i);
            i++;
            return p;
        }
    }
}
