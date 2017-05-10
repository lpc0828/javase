package com.pengcheng.socket.blockingIO.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 17-3-20 下午2:39.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class SocketServer {

    public static void main(String[] args) {
        int port = 10000;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                new Thread(new SokcetRunnalbe(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (!serverSocket.isClosed()) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
