package com.zhangfeng.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName FileChannelDemo1
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/14 20:26
 */
public class FileChannelDemo {

    public static void main(String[] args) throws Exception {
//        readFile();
//        writeFile();
//        transform();
        transTo();

    }

    private static void transTo() throws IOException{
        RandomAccessFile fromFile = new RandomAccessFile("d:\\channel.txt", "rw");
        RandomAccessFile toFile = new RandomAccessFile("d:\\channel2.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();
        FileChannel toChannel = toFile.getChannel();
        fromChannel.transferTo(fromChannel.position(),fromChannel.size(),toChannel);
        fromChannel.close();
        toChannel.close();
    }

    //channel之间数据传输
    private static void transform() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("d:\\channel.txt", "rw");
        RandomAccessFile toFile = new RandomAccessFile("d:\\channel2.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();
        FileChannel toChannel = toFile.getChannel();
        toChannel.transferFrom(fromChannel,fromChannel.position(),fromChannel.size());
        fromChannel.close();
        toChannel.close();
    }

    //FileChannel 写操作
    private static void writeFile() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("d:\\channel.txt","rw");

        FileChannel channel = aFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String newData = "data file channel";

        buffer.clear();
        //写入数据
        buffer.put(newData.getBytes());

        buffer.flip();

        //filechannel完成最终实现
        while (buffer.hasRemaining()){
            channel.write(buffer);
        }

        channel.close();
    }

    //FileChannel读取数据到buffer中
    private static void readFile() throws IOException {
        //创建FileChannel，通过流。inputStream outputStream ，或者randomAccessFile
        RandomAccessFile aFile = new RandomAccessFile("d:\\channel.txt","rw");
        FileChannel channel = aFile.getChannel();

        //创建buffer缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //读取数据到buffer中

        int byteRead = channel.read(buf);

        //表示有内容
        while (byteRead != -1){
            System.out.println("读取了:"+ byteRead);
            //读写模式转换
            buf.flip();
            while (buf.hasRemaining()){
                System.out.println((char) buf.get());
            }
            buf.clear();
            byteRead = channel.read(buf);
        }
        aFile.close();
        System.out.println("结束了");
    }
}
