package nio;

/**
 * @Author： yuzq
 * @Description: Channel通道
 * @Date: 2020/1/13   9:26
 *
 * FileChannel不能使非阻塞式
 * 主要实现类
 *      java.nio.channels.channel
 *          FileChannel    本地
 *          SocketChannel           网络
 *          SocketChannel           网络
 *          ServerSocketChannel     网络
 *          DatagramChannel         网络
 *
 *        1.获取getChannel方法  本地IO
 *
 *        JDK 1.7 中NIO2针对各个通道提供了静态方法 open()
 *        JDK 1.7中NIO2的Files 工具类的NewByteChannel()
 */
public class Demo2Channel {

    //利用通道完成文件复制

}
