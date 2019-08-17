package pratice.constructor;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:45 2019-03-29
 * @ Description：父类
 * @ Modified By：
 * @Version: $
 */
public class Father {
    private String s;
    private int value;
//    Father() {
//        System.out.println("父类构造器");
//    }

       Father(String s,int value) {
        System.out.println("父类构造器" + s + value);
        this.s = s;
    }
}
