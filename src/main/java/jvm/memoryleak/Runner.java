package jvm.memoryleak;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 11:17 2019-03-24
 * @ Description：测试运行类
 * @ Modified By：
 * @Version: $
 */
public class Runner {

    /**
     * 测试：一个重写对象hashcode方法使得改变了某个属性会改变hashcode
     * 在HashSet中存放的原来的引用指向了哪里
     */
    @Test
    public void test1() {
        Person person = new Person(3,"lisi");
        HashSet<Person> set = new HashSet<>();
        set.add(person);
        person.setAge(4);
        System.out.println(set.remove(person)); // 此时虽然是同一个对象但是hashcode变化了，导致删除失败
        Iterator<Person> iterator = set.iterator();
        while (iterator.hasNext()) {
            Person p = iterator.next();
            System.out.println(p.getAge());
            //依然存在这个对象，只是此时hashset里以依据的hashcode和实际对象中hashcode不一样
        }
    }

    /**
     * 他们所持有的对象不能释放，即便这个对象为null，
     * 也会一直在hashmap中引用不被回收，如果想回收这个对象必须在hashmap中remove。
     */
    @Test
    public void test2() {
        while (true) {
            Object o = new Object();
            HashSet set = new HashSet();
            set.add(o);
            o = null;
        }
        }
}
