package pengcheng.timer;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;

import java.util.List;

public class TimerManager {

    public static void main(String[] args) {
        List<String> queue = Lists.newArrayList("aaaa");
        while (true) {
            synchronized (queue) {
                try {
                    queue.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(DateTime.now().toString("yyyy-MM-dd HH:mm:ss.SSS"));
            }
        }
    }


}
