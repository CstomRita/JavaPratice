package MutiThread.LearnTest;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午12:51 2018/9/22
 * @ Description：父类
 * @ Modified By：
 * @Version: $
 */
public class Father {

    synchronized public void printMssage(){
        System.out.println("调用父类同步方法");
    }

}
