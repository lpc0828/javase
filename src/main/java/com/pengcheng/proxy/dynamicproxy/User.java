package com.pengcheng.proxy.dynamicproxy;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by IntelliJ IDEA.
 *
 * @version V1.0.0
 * @author: <a href="mailto:pengcheng.liu0828@gmail.com">pc.liu</a>.
 * @since: 2016/11/13.
 */
public class User {
    private static AtomicLong counter = new AtomicLong(0);
    private Long id;
    private String userName;
    private String passwd;

    public static Long genId() {
        return counter.incrementAndGet();
    }

    public User(String userName, String passwd) {
        this.id = genId();
        this.userName = userName;
        this.passwd = passwd;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswd() {
        return passwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
