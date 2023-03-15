package com.zhangfeng.nio.chatroom.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName ChatServer
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/15 15:26
 */
//服务器
public class ChatServer {

    //服务器端启动的方法
    public void startServer() throws IOException {
        //1.创建selector选择器
        Selector selector = Selector.open();
        //2.创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //3.为channel通道绑定监听端口,通道非阻塞模式
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8000));

        //4把channel注册到选择器中
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器已经启动成功了");

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

                //6.根据就绪的状态，调用对应的方法实现业务操作
                //6.1如果是accept状态

                if(selectionKey.isAcceptable()){
                    //do something
                    acceptOperator(serverSocketChannel,selector);
                }

                //6.2如果是可读

                if(selectionKey.isReadable()){
                   readOperator(selector,selectionKey);
                }

            }
        }



    }


    //处理可读状态操作
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
            castOtherClient(message,selector,socketChannel);
        }
    }

    //广播给其他客户端
    private void castOtherClient(String message, Selector selector, SocketChannel socketChannel) throws IOException {
       //1.获取所有已经接入客户端
        Set<SelectionKey> selectionKeySet = selector.keys();

        //2.循环向所有channel广播
        for(SelectionKey selectionKey : selectionKeySet){
            //获取里面每个channel
            Channel tarChannel = selectionKey.channel();
            //不需要给自己发送
            if(tarChannel instanceof  SocketChannel && tarChannel != socketChannel){
                ((SocketChannel) tarChannel).write(Charset.forName("UTF-8").encode(message));
            }

        }

    }

    //处理接入状态操作
    private void acceptOperator(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        //1.接入状态，创建socketChannel
        SocketChannel socketChannel = serverSocketChannel.accept();
        //2.把socketChannel设置为非阻塞
        socketChannel.configureBlocking(false);
        //3.把channel注册到selector监听可读操作
        socketChannel.register(selector,SelectionKey.OP_READ);
        //4.客户端回复信息
        socketChannel.write(Charset.forName("UTF-8").encode("欢迎进入聊天室"));
    }


    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer();
        chatServer.startServer();

    }
}
