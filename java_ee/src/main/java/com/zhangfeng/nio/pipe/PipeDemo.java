package com.zhangfeng.nio.pipe;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @ClassName PipeDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/15 15:13
 */
public class PipeDemo {

    public static void main(String[] args) throws IOException {
        //1.获取管道
        Pipe pipe = Pipe.open();
        //2.获取sink通道
        Pipe.SinkChannel sinkChannel = pipe.sink();
        //3.创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("管道".getBytes());
        byteBuffer.flip();

        //4.写入数据
        sinkChannel.write(byteBuffer);
        //5.获取source通道
        Pipe.SourceChannel source = pipe.source();
        //6.创建缓冲区，读取数据
        ByteBuffer resBuffer = ByteBuffer.allocate(1024);
//        byteBuffer.flip();
        int length = source.read(resBuffer);
        System.out.println(new String(resBuffer.array(),0,length));

        //7 关闭
        source.close();
        sinkChannel.close();

    }
}
