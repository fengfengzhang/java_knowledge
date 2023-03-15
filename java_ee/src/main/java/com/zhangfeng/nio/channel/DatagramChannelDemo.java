package com.zhangfeng.nio.channel;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

/**
 * @ClassName DatagramChannelDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/14 21:32
 */
//对应UDP
public class DatagramChannelDemo {

    //发送的实现
    @Test
    public void sendDatagram() throws IOException, InterruptedException {
        //打开 DatagramChannel
        DatagramChannel sendChannel = DatagramChannel.open();
        InetSocketAddress sendAddress = new InetSocketAddress("127.0.0.1",9999);
        while (true){
            ByteBuffer buffer = ByteBuffer.wrap("发送数据".getBytes("UTF-8"));
            sendChannel.send(buffer,sendAddress);
            System.out.println("已经完成了发送");
            Thread.sleep(1000);
        }
    }

    //接收的实现
    @Test
    public void receiveDatagram() throws IOException {
      //打开DatagramChannel
        DatagramChannel receiveChannel = DatagramChannel.open();
        InetSocketAddress socketAddress = new InetSocketAddress(9999);
        //绑定
        receiveChannel.bind(socketAddress);

        //buffer
        ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);

        //接收
        while (true){
            receiveBuffer.clear();
            SocketAddress address = receiveChannel.receive(receiveBuffer);
            receiveBuffer.flip();

            System.out.println(address.toString());

            System.out.println(Charset.forName("UTF-8").decode(receiveBuffer));

        }
    }

    //演示 连接 read write

    @Test
    public void testConnect() throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        //绑定端口
        channel.bind(new InetSocketAddress(9999));
        channel.connect(new InetSocketAddress("127.0.0.1",9999));

        //write方法
        channel.write(ByteBuffer.wrap("发送数据".getBytes("UTF-8")));

        //buffer

        ByteBuffer readBuffer = ByteBuffer.allocate(1024);

        while (true){
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("收到"+Charset.forName("UTF-8").decode(readBuffer));
        }


    }
}
