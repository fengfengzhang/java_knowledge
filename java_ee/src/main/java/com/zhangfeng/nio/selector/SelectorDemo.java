package com.zhangfeng.nio.selector;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName SelectorDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/15 14:05
 */
public class SelectorDemo {
    /**
     * 1创建ServerSocketChannel通道，绑定监听窗口
     * 2设置通道为非阻塞模式
     * 3创建Selcetor选择器
     * 4把Channel注册到selector选择器上监听时间
     * 5.调用Selector的select方法（循环调用），监听通道就绪情况
     * 6.调用selectKey方法获取就绪channel集合
     * 7遍历channle集合，判断就绪的事件类型，实现具体业务操作
     * 8根据业务是否需要再次注册监听事件重复执行
     */


    //客户端代码
    @Test
    public void clientDemo() throws IOException {
        //1.获取通道，绑定主机和端口号
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8080));

        //2.切换到非阻塞模式
        socketChannel.configureBlocking(false);

        //3.创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //4.写入buffer数据
        byteBuffer.put(new Date().toString().getBytes());

        //5.模式切换
        byteBuffer.flip();

        //6.写入通道
        socketChannel.write(byteBuffer);

        //7.关闭
        byteBuffer.clear();
        socketChannel.close();
    }

    //服务端代码
    @Test
    public void serverDemo() throws IOException {
        //1.获取服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.切换为非阻塞状态
        serverSocketChannel.configureBlocking(false);
        //3.创建buffer
        ByteBuffer serverByteBuffer = ByteBuffer.allocate(1024);

        //4.绑定端口号
        serverSocketChannel.bind(new InetSocketAddress(8080));
        //5.获取selector选择器
        Selector selector = Selector.open();

        //6.通道注册到选择器，进行监听
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        //7.选择器轮询
        while (selector.select() > 0){
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //遍历
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                //获取到就绪操作
                SelectionKey next = iterator.next();
                if(next.isAcceptable()){
                    //获取连接
                    SocketChannel accept = serverSocketChannel.accept();
                    //切换非阻塞
                    accept.configureBlocking(false);

                    //注册
                    accept.register(selector,SelectionKey.OP_READ);
                }else if(next.isReadable()){
                   SocketChannel channel = (SocketChannel)next.channel();
                   ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                   //数据读取
                    byteBuffer.clear();
                    int length = 0;
                    while ((length = channel.read(byteBuffer)) > 0){
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(),0,length));
                        byteBuffer.clear();
                    }

                }
                iterator.remove();
            }

        }


    }

    public static void main(String[] args) throws IOException {
        //1.获取通道，绑定主机和端口号
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8080));

        //2.切换到非阻塞模式
        socketChannel.configureBlocking(false);

        //3.创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            //4.写入buffer数据
            byteBuffer.put((new Date().toString() + "----->" + str).getBytes());

            //5.模式切换
            byteBuffer.flip();

            //6.写入通道
            socketChannel.write(byteBuffer);

            //7.关闭
            byteBuffer.clear();
        }



        socketChannel.close();
    }





    @Test
    public void selector01() throws IOException {
        //创建selector 只能与非阻塞的channel一块使用
        Selector selector = Selector.open();

        //通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //非阻塞
        serverSocketChannel.configureBlocking(false);
        //绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9999));

        //将通道绑定在选择器, 接受阻塞操作
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //查询哪些通道进入就绪了,把就绪状态查出来
        Set<SelectionKey> selectionKeys = selector.selectedKeys();

        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while (iterator.hasNext()){
            SelectionKey key = iterator.next();
            //判断key就行状态操作
            if(key.isAcceptable()){
                System.out.println("1111");
            }



        }
        iterator.remove();


    }
}
