package com.pengcheng.socket.blockingIO.server;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 17-3-20 下午4:08.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class SessionHandler {

    private static ConcurrentHashMap<Socket, String> clients = new ConcurrentHashMap<Socket, String>();

    public static synchronized void sendMessage(Socket besideClient, String msg, boolean bSayName) {
        if (StringUtils.isBlank(msg)) {
            return;
        }
        for (Socket client : clients.keySet()) {
            if (!client.equals(besideClient)) {
                try {
                    if (bSayName) {
                        client.getOutputStream().write(StringUtils.join(clients.get(besideClient), "说:", msg, "\n").getBytes("UTF-8"));
                    } else {
                        client.getOutputStream().write(StringUtils.join(msg, "\n").getBytes("UTF-8"));
                    }
                    client.getOutputStream().flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static synchronized void rename(Socket socket, String newName) {
        String beforeName = clients.get(socket);
        String msg = StringUtils.join("客户 ", beforeName, " 更名为 ", newName);
        clients.put(socket, newName);
        sendMessage(socket, msg, false);
        try {
            socket.getOutputStream().write(StringUtils.join("您已更名为：", newName, "\n").getBytes("UTF-8"));
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void join(Socket socket) {
        String clientName = StringUtils.join(socket.getInetAddress().getHostAddress(), ":", socket.getPort());
        String msg = StringUtils.join("欢迎客户 ", clientName, " 加入会话");
        clients.put(socket, clientName);
        sendMessage(socket, msg, false);
    }

    public static synchronized void leave(Socket socket) {
        String clientName = clients.get(socket);
        String msg = StringUtils.join("客户 ", clientName, " 已离开 ");
        sendMessage(socket, msg, false);
        clients.remove(socket);
    }
}
