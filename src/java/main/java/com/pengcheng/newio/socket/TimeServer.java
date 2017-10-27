package pengcheng.newio.socket;

public class TimeServer {

    public static void main(String[] args) {
        int port = 9527;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        new Thread(new MultiplexerTimeServer(port), "NIO-MultiplexerTimeServer-001").start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new TimeClientHandle("127.0.0.1", port)).start();
    }
}
