package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/28
 */

public class TestChannel {
    public static final int SIZE = 1024;

    public static void main(String[] args) throws IOException {
        //打开文件输入流
        FileChannel inChannel = new FileInputStream("C:\\Users\\Dawn\\Desktop\\tifa.jpg").getChannel();
        //打开文件输出流
        FileChannel outChannel = new FileOutputStream("C:\\Users\\Dawn\\Desktop\\Java\\tifa.jpg").getChannel();

        //分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(SIZE);

        //将数据从通道读入缓冲区
        while (inChannel.read(buffer) != -1) {

            //切换缓冲区的读写模式
            buffer.flip();

            //将缓冲区的数据通过通道写入目的地
            outChannel.write(buffer);

            //清空缓冲区，准备下一次读
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();
    }
}
