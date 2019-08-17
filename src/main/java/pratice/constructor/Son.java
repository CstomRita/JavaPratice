package pratice.constructor;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:45 2019-03-29
 * @ Description：子类
 * @ Modified By：
 * @Version: $
 */
public class Son extends Father {

    private String s;
    private int value;
//    Son() {
//        System.out.println("子类构造器");
//    }

//    Son(int value) {
//        this.value = value;
//        System.out.println("son" + value);
//    }
    Son(String s,int value) {
        super(s,value);
        System.out.println("子类构造"+ s);
        this.s = s;
    }
}
