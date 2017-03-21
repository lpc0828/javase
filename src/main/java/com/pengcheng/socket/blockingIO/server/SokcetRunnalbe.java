package com.pengcheng.socket.blockingIO.server;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.Socket;

/**
 * @version 17-3-20 下午3:03.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class SokcetRunnalbe implements Runnable {

    private Socket clientSocket;
    private String clientName;

    private static String HELP = "操作指令:\t--help 帮助;\trename:昵称 修改自己的昵称;\tquit 退出\n";

    public SokcetRunnalbe(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.clientName = StringUtils.join(clientSocket.getInetAddress().getHostAddress(), ":", clientSocket.getPort());
        SessionHandler.join(this.clientSocket);
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = clientSocket.getInputStream();
            out = clientSocket.getOutputStream();
            out.write(StringUtils.join("欢迎光临：", this.clientName, "\n").getBytes("UTF-8"));
            out.write(StringUtils.join(HELP).getBytes());
            out.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            while (true) {
                String recvQ = reader.readLine();
                System.out.println("客户指令："+recvQ);
                if (StringUtils.isBlank(recvQ)) {
                    continue;
                }
                if (recvQ.matches("--help")) {
                    out.write(StringUtils.join(HELP).getBytes("UTF-8"));
                    out.flush();
                    continue;
                }
                if (recvQ.startsWith("rename:") && StringUtils.isNotBlank(recvQ.replace("rename:", ""))) {
                    String newName = StringUtils.trimToEmpty(recvQ.replace("rename:", ""));
                    SessionHandler.rename(clientSocket, newName);
                    this.clientName = newName;
                    continue;
                }
                if (StringUtils.equals(recvQ, "quit")) {
                    SessionHandler.leave(clientSocket);
                    break;
                }
                SessionHandler.sendMessage(clientSocket, recvQ, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (!clientSocket.isClosed()) {
                    clientSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
