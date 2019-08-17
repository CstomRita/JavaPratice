package nio;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 11:26 2019-06-24
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class TestBuffer {

    @Test
    public void test1() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("初始化:positon :" + byteBuffer.position()
                + ",limit:" + byteBuffer.limit()
                + ", capacity:" + byteBuffer.capacity()
                + ", mark:" + byteBuffer.mark() );

        byteBuffer.put("abcde".getBytes());
        System.out.println("put，positon :" + byteBuffer.position()
                + ",limit:" + byteBuffer.limit()
                + ", capacity:" + byteBuffer.capacity()
                + ", mark:" + byteBuffer.mark() );

        Buffer flip = byteBuffer.flip();
        System.out.println(flip);
        System.out.println("flip，positon :" + byteBuffer.position()
                + ",limit:" + byteBuffer.limit()
                + ", capacity:" + byteBuffer.capacity()
                + ", mark:" + byteBuffer.mark() );

        System.out.println(byteBuffer.get());
        System.out.println("get，positon :" + byteBuffer.position()
                + ",limit:" + byteBuffer.limit()
                + ", capacity:" + byteBuffer.capacity()
                + ", mark:" + byteBuffer.mark() );

        byteBuffer.clear();
        System.out.println("put，positon :" + byteBuffer.position()
                + ",limit:" + byteBuffer.limit()
                + ", capacity:" + byteBuffer.capacity()
                + ", mark:" + byteBuffer.mark() );

        System.out.println(byteBuffer.hasRemaining());
    }
}
