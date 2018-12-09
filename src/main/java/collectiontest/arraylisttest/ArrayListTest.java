package collectiontest.arraylisttest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:54 2018/11/4
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class ArrayListTest {

    /**
     * 测试List的深浅拷贝
     */
   @Test
    public void copyInteger() {
       //List初始化赋值的一种方式 new ArrayList(list)
       // 这个list可以是直接的list，也可以Array.asList作为一个List
       List<Integer> currentList = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        List<Integer> list = new ArrayList<Integer>(currentList);
       System.out.println(list);
       System.out.println(currentList);
        currentList.remove(currentList.size() - 1);
       System.out.println(Arrays.toString(currentList.toArray()));
       System.out.println(Arrays.toString(list.toArray()));
       list.remove(list.size()-2);
       System.out.println(Arrays.toString(list.toArray()));
       System.out.println(Arrays.toString(currentList.toArray()));

    }
    class Person {
        String name;
        int age;
        public Person(String name, int age) {
            this.age = age;
            this.name = name;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }

    @Test
    public void copyPerson() {
        Person p1 = new Person("123", 11);
        Person p2 = new Person("1234", 11);
        Person p3 = new Person("12345", 11);
        List<Person> personList = new ArrayList<Person>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        List<Person> list = new ArrayList<Person>(personList);
        personList.remove(personList.size() - 1);
        System.out.println(personList);
        System.out.println(list);
    }

}
