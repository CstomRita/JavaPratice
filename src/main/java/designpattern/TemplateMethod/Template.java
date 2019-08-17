package designpattern.TemplateMethod;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:41 2019-03-19
 * @ Description：模板父类
 * @ Modified By：
 * @Version: $
 */
public abstract class Template {

    public final void print() {
        start();
        System.out.println("模板自带的处理逻辑");
        end();
    }

    protected void start() {
        //可以为空，可以是非abstract，默认不做其他操作
    }

    protected void end() {
        //也可以是abstract
    }

}
