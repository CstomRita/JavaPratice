package designpattern.FactoryMethod;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 20:53 2019-03-29
 * @ Description：具体子类
 * @ Modified By：
 * @Version: $
 */
public class IDCard extends Product {
    private String user;

    public String getUser() {
        return user;
    }


    IDCard(String user) {
        this.user = user;
    }
    @Override
    public void use() {
        System.out.println("使用"+this.user+"的 ID");
    }

    @Override
    public void clear() {
        System.out.println("清除"+this.user+"的ID卡");
    }
}
