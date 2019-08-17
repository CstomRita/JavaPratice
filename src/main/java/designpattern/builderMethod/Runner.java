package designpattern.builderMethod;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:09 2019-04-04
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Runner {

    public static void main(String[] args) {
        Director director = new Director(new BuilderA());
       Product p =  director.getProduct();
        System.out.println("套餐A："+p.getDrink()+p.getFood()+p.getSnack());


        Director director1 = new Director(new BuilderB());
        Product p1 =  director1.getProduct();
        System.out.println("套餐B："+p1.getDrink()+p1.getFood()+p1.getSnack());

    }
}
