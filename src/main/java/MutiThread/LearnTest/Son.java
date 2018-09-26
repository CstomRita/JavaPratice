package MutiThread.LearnTest;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午12:51 2018/9/22
 * @ Description：子类
 * @ Modified By：
 * @Version: $
 */
public class Son extends Father{


    synchronized public void printMessage() {

        System.out.println("调用子类同步方法");
        super.printMssage();
    }

}
