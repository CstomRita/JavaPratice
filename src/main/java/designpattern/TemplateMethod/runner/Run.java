package designpattern.TemplateMethod.runner;

import designpattern.TemplateMethod.ActualPrint;
import designpattern.TemplateMethod.Template;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:45 2019-03-19
 * @ Description：运行
 * @ Modified By：
 * @Version: $
 */
public class Run {
    public static void main(String[] args) {
        Template template = new ActualPrint();
        template.print();
    }
}
