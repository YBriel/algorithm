package nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author： yuzq
 * @Description: 使用NIO完成网络通信的三个核心
 * 1.通道（channel）：负责连接
 * 2.缓冲区 负责数据存取
 * 3.选择器 是SelectableChannel的多路复用器，用于监控SelectableChannel的IO状况
 *
 * @Date: 2020/1/13   10:57
 */
public class Demo3BlockedNiIO {

    @Test
    public void client() throws IOException {
        //获取通道
        String hostname="127.0.0.1";
        InetSocketAddress inetSocketAddress = new InetSocketAddress(hostname, 9898);
        SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);

        FileChannel in=FileChannel.open(Paths.get("yy.png"), StandardOpenOption.READ);

        ByteBuffer buffer=ByteBuffer.allocate(1024);

        //读取本地文件，并发送到服务器
        while (in.read(buffer)!=-1){
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        in.close();
        socketChannel.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        FileChannel fileChannel=FileChannel.open(Paths.get("2.png"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        serverSocketChannel.bind(new InetSocketAddress(9001));
        SocketChannel socketChannel = serverSocketChannel.accept();
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        while (socketChannel.read(buffer)!=-1){
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }
        socketChannel.close();
        fileChannel.close();
        serverSocketChannel.close();
    }
}
