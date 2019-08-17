package jvm.memoryleak;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 11:16 2019-03-24
 * @ Description：一个测试实体类
 * @ Modified By：
 * @Version: $
 */
public class Person {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.age;
    }
}
