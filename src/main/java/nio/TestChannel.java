package nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:56 2019-06-28
 * @ Description：通道测试
 * @ Modified By：
 * @Version: $
 */
public class TestChannel {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        ClassLoader.getSystemResource("");
    }

    @Test
    public void test2() {
        try {
            FileChannel inputChannel = FileChannel.open(Paths.get("src/main/resources/1.txt"), StandardOpenOption.READ);
            FileChannel outputChannel = FileChannel.open(Paths.get("src/main/resources/2.txt"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

            MappedByteBuffer inputBuffer = inputChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputChannel.size());
            MappedByteBuffer outputBuffer = outputChannel.map(FileChannel.MapMode.READ_WRITE,0,inputChannel.size());

            //直接缓冲区的优势在于，不需要通过通道传输数据
            // 直接操作缓冲区就是直接将数据写到内存中，操作系统会自行读写
            byte[] temp = new byte[inputBuffer.limit()];
            inputBuffer.get(temp);
            outputBuffer.put(temp);

            inputChannel.close();
            outputChannel.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
             inputStream = new FileInputStream("src/main/resources/1.txt");
             outputStream = new FileOutputStream("src/main/resources/2.txt");

            //获取通道
             inputChannel = inputStream.getChannel();
             outputChannel = outputStream.getChannel();

            //创建一个buffer temp
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            while (inputChannel.read(byteBuffer) != -1) { //表示还未读取完
                // (buffer的读数据模式表示是从buffer中读取数据，读取出的数据写到通道中)
                byteBuffer.flip();
                outputChannel.write(byteBuffer);
                byteBuffer.clear();
            }

            //关闭
            outputChannel.close();
            inputChannel.close();
            inputStream.close();
            outputStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }

}
