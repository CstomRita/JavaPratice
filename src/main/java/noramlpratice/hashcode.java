package noramlpratice;

import org.junit.Test;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午7:22 2018/11/19
 * @ Description：HashCode的具体指向，如何判断两个对象相等
 * @ Modified By：
 * @Version: $
 */
public class hashcode {

    class Person {
        private String name;
        Person(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Person) {
                Person person = (Person)obj;
                return this.name.equals(person.name);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode();
        }
    }

    @Test
    public void test() {
        Person person1 = new Person("123");
        Person person2 = new Person("123");
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person1.equals(person2));
        System.out.println(person1==person1);
        Integer integer = new Integer(1);
        System.out.println(integer.hashCode());
       integer = 2;
        System.out.println(integer.hashCode());
    }
}
