package org.zzh.server;

import org.zzh.domain.User;
import org.zzh.server.serviceImpl.UserServiceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：ZiHao Zhang
 * @date ：2022/3/21 11:19
 */
public class MyServer {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        try {
            ServerSocket socket = new ServerSocket(8041);
            System.out.println("服务器启动");
            int count = 0;
            while(true) {
                Socket accept = socket.accept();
                System.out.println("远程调用次数：" + ++count);
                new Thread(() -> {
                    try {
                        ObjectOutputStream outputStream = new ObjectOutputStream(accept.getOutputStream());
                        ObjectInputStream inputStream = new ObjectInputStream(accept.getInputStream());
                        Integer id = inputStream.readInt();
                        System.out.println("id:" + id);
                        User user = userService.getById(id);
                        outputStream.writeObject(user);
                        outputStream.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
