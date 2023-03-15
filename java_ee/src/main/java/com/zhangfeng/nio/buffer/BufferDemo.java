package com.zhangfeng.nio.buffer;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName BufferDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/15 12:55
 */
public class BufferDemo {

    //读文件到buffer中
    @Test
    public void buffer01() throws IOException {
        //FileChannel
        RandomAccessFile aFile = new RandomAccessFile("d:\\channel.txt","rw");
        FileChannel channel = aFile.getChannel();

        //创建buffer,大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //读取
        int byteRead = channel.read(buffer);

        while (byteRead != -1){
            //read 模式
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());
            }
            buffer.clear();
            byteRead = channel.read(buffer);

        }

        aFile.close();

    }

    //向buffer中写数据后打印
    @Test
    public void buffer02(){
        //创建buffer

        IntBuffer buffer = IntBuffer.allocate(8);

        //buffer放
        for(int i = 0 ;i < buffer.capacity() ; i++){
            int j = (int) (2 * Math.random() * 100);
            buffer.put(j);
        }
        //重置缓冲区
        buffer.flip();

        //获取
        while(buffer.hasRemaining()) {
            int value = buffer.get();
            System.out.println(value);
        }
    }


    //子缓冲区
    @Test
    public void buffer03(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for(int i = 0; i < byteBuffer.capacity() ; i++){
            byteBuffer.put((byte)i);
        }

        //创建子缓冲区
        byteBuffer.position(3);
        byteBuffer.limit(7);
        ByteBuffer slice = byteBuffer.slice();

        //改变子缓冲区内容
        for(int i = 0 ; i < slice.capacity() ; i++){
            byte b = slice.get(i);
            b *= 10;
            slice.put(i,b);
        }

        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());

        while (byteBuffer.remaining() > 0){
            System.out.println(byteBuffer.get());
        }
    }

    //只读缓冲区 ,只读缓冲区会随着原缓冲区的变化而变化
    @Test
    public void buffer04(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for(int i = 0; i < byteBuffer.capacity() ; i++){
            byteBuffer.put((byte)i);
        }

        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();

        for(int i = 0; i < byteBuffer.capacity() ; i++){
            byte b = byteBuffer.get(i);
            b *= 10;
            byteBuffer.put(i,b);
        }

        readOnlyBuffer.position(0);
        readOnlyBuffer.limit(readOnlyBuffer.capacity());

        while (readOnlyBuffer.hasRemaining()){
            System.out.println(readOnlyBuffer.get());
        }
    }

    //创建直接缓冲区
    @Test
    public void buffer05() throws IOException {
        String infile = "d:\\channel.txt";
        FileInputStream fin = new FileInputStream(infile);
        FileChannel finChannel = fin.getChannel();

        String outfile = "d:\\channel2.txt";
        FileOutputStream fout = new FileOutputStream(outfile);
        FileChannel fOutChannel = fout.getChannel();

        //创建直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true){
            buffer.clear();
            int read = finChannel.read(buffer);
            if(read == -1){
                break;
            }
            buffer.flip();
            fOutChannel.write(buffer);


        }

    }

}
