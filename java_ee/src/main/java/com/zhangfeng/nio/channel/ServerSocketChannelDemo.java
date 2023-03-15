package com.zhangfeng.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @ClassName ServerSocketChannelDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/14 21:07
 */
public class ServerSocketChannelDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        //端口号
        int port = 8888;

        //buffer
        ByteBuffer buffer = ByteBuffer.wrap("hello".getBytes());

        //ServerSocketChanel
        ServerSocketChannel ssc = ServerSocketChannel.open();

        //绑定
        ssc.socket().bind(new InetSocketAddress(port));

        //设置非阻塞模式
        ssc.configureBlocking(false);

        //监听是否新的链接进行传入
        while (true){
            System.out.println("waiting for connect");
            SocketChannel sc = ssc.accept();
            if(sc == null){
                System.out.println("没有链接传入");
                Thread.sleep(2000);
            }else{
                System.out.println("有链接传入" + sc.socket().getRemoteSocketAddress());
                buffer.rewind();//指针指向0
                sc.write(buffer);
                sc.close();
            }

        }

    }
}
