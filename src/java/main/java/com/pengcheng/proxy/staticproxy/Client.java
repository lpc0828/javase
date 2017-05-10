package com.pengcheng.proxy.staticproxy;

/**
 * Created by IntelliJ IDEA.
 *
 * @version V1.0.0
 * @author: <a href="mailto:pengcheng.liu0828@gmail.com">pc.liu</a>.
 * @since: 2016/11/13.
 */
public class Client {

    public static void main(String[] args) {
        Subject proxy = new ProxySubject();
        proxy.request();
    }
}
