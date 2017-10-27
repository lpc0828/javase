package pengcheng.newio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.Iterator;

public class MultiplexerTimeServer implements Runnable {

    private Selector selector;
    private ServerSocketChannel servChannel;
    private volatile boolean stop;

    public MultiplexerTimeServer(int port) {
        try {
            // 1.打开ServerSocketChannel, 用于监听客户端的连接，它是所有客户端连接的父管道
            servChannel = ServerSocketChannel.open();
            // 2.绑定监听端口，设置连接为非阻塞模式
            servChannel.socket().bind(new InetSocketAddress(port), 1024);
            servChannel.configureBlocking(false);
            // 3.创建Reactor线程，创建多路复用器并启动线程
            selector = Selector.open();
            // 4. 将ServerSocketChannel注册到Reactor线程的多路复用器Selector上，监听ACCEPT事件，
            servChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectedKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            //处理新接入的请求信息
            if (key.isAcceptable()) {
                // 接受新的连接
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                // Add the new connection to the selector
                sc.register(selector, SelectionKey.OP_READ);
            }
            if (key.isReadable()) {
                // 读取数据
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0) {
                    // 返回值大于0： 读取到了字节，对字节进行编解码
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8").trim();
                    System.out.println("The time server receive order:" + body);
                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ?
                            new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                    doWrite(sc, currentTime);
                } else if (readBytes < 0) {
                    // 返回值为-1，链路寂静关闭，需要关闭SocketChannel，释放资源
                    key.cancel();
                    sc.close();
                } else {
                    // 返回值等于0： 没有读取到字节，属于正常场景，忽略即可
                    ;
                }
            }
        }
    }

    private void doWrite(SocketChannel channel, String response) throws IOException {
        if (!Objects.isNull(response) && response.trim().length() > 0) {
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }
}
