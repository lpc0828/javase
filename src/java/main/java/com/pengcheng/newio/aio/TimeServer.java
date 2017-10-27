package pengcheng.newio.aio;

public class TimeServer {

    public static void main(String[] args) {
        int port = 9527;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }

        AsyncTimeServerHandler timeServerHandler = new AsyncTimeServerHandler(port);
        new Thread(timeServerHandler, "AIO-AsyncTimeServerHandler-001").start();
    }

}
