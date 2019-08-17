package designpattern.iteratorPattern;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:59 2019-04-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public interface Iterator<E> {
    public boolean hasNext();
    public E next();
}
