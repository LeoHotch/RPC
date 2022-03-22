package org.zzh.client;

import org.zzh.domain.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

/**
 * @author ：ZiHao Zhang
 * @date ：2022/3/21 11:19
 */
public class MyClient {
    private static final int MAX = 2;
    public static void main(String[] args) {
        int count = 1;
        try {
            while(count <= MAX) {
                Random random = new Random();
                Socket socket = new Socket("127.0.0.1", 8041);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                outputStream.writeInt(random.nextInt());
                outputStream.flush();
                System.out.println("刷入成功");
                User user = (User)inputStream.readObject();
                System.out.println("服务器端返回的User：" + user);
                count++;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
