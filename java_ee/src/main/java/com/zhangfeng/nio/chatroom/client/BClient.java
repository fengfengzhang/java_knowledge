package com.zhangfeng.nio.chatroom.client;

import java.io.IOException;

/**
 * @ClassName BClient
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/15 16:44
 */
public class BClient {
    public static void main(String[] args) throws IOException {
        new ChatClient().startClient("Marry");
    }
}
