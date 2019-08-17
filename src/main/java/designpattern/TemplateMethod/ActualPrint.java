package designpattern.TemplateMethod;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:44 2019-03-19
 * @ Description：实际处理子类
 * @ Modified By：
 * @Version: $
 */
public class ActualPrint extends Template {

    @Override
    protected void start() {
        System.out.println("子类自己的处理流程");
    }

    @Override
    protected void end() {
        // 子类可以写自己方法
        release();
    }

    private void release() {
        System.out.println("子类自己的结束流程");
    }
}
