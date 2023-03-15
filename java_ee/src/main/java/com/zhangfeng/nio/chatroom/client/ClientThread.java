package com.zhangfeng.nio.chatroom.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName ClientThread
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/15 16:37
 */
public class ClientThread implements Runnable{

    private Selector selector;
    public ClientThread(Selector selector){
        this.selector = selector;
    }

    @Override
    public void run() {
       try{
        //5.循环，等待是否新的连接接入
        for (;;){
            //获取channel数里
            int readChannels = selector.select();
            if(readChannels == 0){
                continue;
            }
            //获取可用channel
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();

                //移除set集合当前的selectKey
                iterator.remove();


                //6.2如果是可读

                if(selectionKey.isReadable()){
                    readOperator(selector,selectionKey);
                }
            }

            }
        }catch (Exception e){

       }
    }

    private void readOperator(Selector selector, SelectionKey selectionKey) throws IOException {
        //1.selectionKey 获取到已经就绪的通道
        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
        //2.创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //3.循环读取客户端消息
        int readLength = socketChannel.read(byteBuffer);
        String message = "";
        while (readLength > 0){
            //切换读模式
            byteBuffer.flip();

            //读取内容
//            message += Charset.forName("UTF-8").decode(byteBuffer);
            message += new String(byteBuffer.array(),0,readLength);
            byteBuffer.clear();
            readLength = socketChannel.read(byteBuffer);
        }

        //4.把channel再次注册到选择器，监听可读状态
        socketChannel.register(selector,SelectionKey.OP_READ);

        //5.把客户端发送消息。广播到其他客户端
        if(message.length() > 0){
            System.out.println(message);
        }
    }
}
