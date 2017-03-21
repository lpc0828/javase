package com.pengcheng.socket.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @version 17-3-21 下午5:58.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class NIOServerTest {

    private static int port = 9888;

    public static void main(String[] args) {
        try {
            startServer(9888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startServer(int port) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        SocketAddress address = new InetSocketAddress(port);
        ssc.socket().bind(address);
        ssc.configureBlocking(false);

        SelectionKey key = ssc.register(selector, SelectionKey.OP_ACCEPT);
        printKeyInfo(key);

        while (true) {
            debug("NBTest: Starting select");
            int nKey = selector.select();
            if (nKey > 0) {
                Set selectedKeys = selector.selectedKeys();
                Iterator iterator = selectedKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey sKey = (SelectionKey)iterator.next();
                    printKeyInfo(sKey);
                    iterator.remove();
                    if (sKey.isAcceptable()) {
                        Socket socket = ((ServerSocketChannel) sKey.channel()).accept().socket();
                        SocketChannel sc = socket.getChannel();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ);
                    } else {
                        debug("NBTest: Channel not acceptable");
                    }
                }
            } else {
                debug("NBTest: Select finished without any keys.");
            }
        }
    }

    private static void printKeyInfo(SelectionKey sk)
    {
        String s = new String();

        s = "Att: " + (sk.attachment() == null ? "no" : "yes");
        s += ", Read: " + sk.isReadable();
        s += ", Acpt: " + sk.isAcceptable();
        s += ", Cnct: " + sk.isConnectable();
        s += ", Wrt: " + sk.isWritable();
        s += ", Valid: " + sk.isValid();
        s += ", Ops: " + sk.interestOps();
        debug(s);
    }

    private static void debug(String s)
    {
        System.out.println(s);
    }
}
