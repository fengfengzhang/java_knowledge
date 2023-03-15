package com.zhangfeng.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @ClassName SocketChannelDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/14 21:21
 */
public class SocketChannelDemo {

    public static void main(String[] args) throws IOException {
        //创建socketchannel
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("www.bai.com", 80));

        /*SocketChannel socketChannel2 = SocketChannel.open();
        socketChannel2.connect(new InetSocketAddress("www.baidu.com",80));
       */
        //设置阻塞非阻塞
        socketChannel.configureBlocking(false);

        //读操作
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        socketChannel.read(byteBuffer);
        socketChannel.close();
        System.out.println("read over");


    }
}
