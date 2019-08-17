package designpattern.prototype;

import java.io.*;
import java.util.ArrayList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:03 2019-04-02
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Thing implements Cloneable,Serializable{
    //定义一个私有变量
    public final ArrayList<Integer> arrayList =
            new ArrayList<Integer>(){
        {
            add(1);
            add(2);
            add(3);
        }
    };

    @Override
    public Thing clone(){
        Thing thing=null;
        PipedOutputStream out=new PipedOutputStream();
        PipedInputStream in=new PipedInputStream();
        try {
            in.connect(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectOutputStream bo=new ObjectOutputStream(out);
            ObjectInputStream bi=new ObjectInputStream(in);) {
            bo.writeObject(this);
            thing=(Thing) bi.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return thing;
    }
}
