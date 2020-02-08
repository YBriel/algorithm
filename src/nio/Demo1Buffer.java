package nio;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @Author： yuzq
 * @Description: Buffer负责数据存取。缓冲区就是数组，用于存储不同数据类型
 * 根据数据类型不同（boolean除外)提供了相应类型的缓冲区
 * @Date: 2020/1/11   11:06
 *
 * ByteBuffer  IntBufffer   DoubleBuffer
 * CharBuffer   LongBuffer
 * ShortBuffer  LongBuffer
 *
 * capacity 容量 缓冲区中最大存储数据的容量 。一旦声明不能改变
 * limit 标识缓存区中可以操作数据大小  （limit后数据不能进行读写)
 * mark 标记当前position位置 可以通过reset恢复到mark位置
 * position 位置，表示缓冲区中正在操作数据的位置
 *
 * 0<= mark <=position <= limit <=capacity
 *
 *
 * 直接缓冲区与非直接缓冲区
 * 非直接缓冲区：通过allocate方法分配缓冲区，将缓冲区建立在JVM内存中
 * 直接缓冲区： 通过allocateDirect方法分配直接缓冲区，将缓冲区建立在物理内存中
 */
public class Demo1Buffer {

    private void sout(ByteBuffer buffer){
        System.out.println("position\t"+buffer.position());
        System.out.println("limit\t"+buffer.limit());
        System.out.println("capacity\t"+buffer.capacity());
        System.out.println("mark\t"+buffer.mark());
        System.out.println("_________________________");
        System.out.println("_________________________");
        System.out.println();
    }

    @Test
    public void test1(){
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        this.sout(buffer);
        System.out.println("put方法之后");
        buffer.put("Hello南昌".getBytes());
        this.sout(buffer);
        //切换到读取数据模式
        buffer.flip();
        System.out.println("flip方法之后");
        this.sout(buffer);
        byte[] bytes=new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes,0,bytes.length));
        this.sout(buffer);
    }
}
