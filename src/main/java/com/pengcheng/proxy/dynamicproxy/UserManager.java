package com.pengcheng.proxy.dynamicproxy;

/**
 * Created by IntelliJ IDEA.
 *
 * @version V1.0.0
 * @author: <a href="mailto:pengcheng.liu0828@gmail.com">pc.liu</a>.
 * @since: 2016/11/13.
 */
public interface UserManager {

    boolean add(User user);

    void del(User user);

    User find(User user);

    boolean update(User user);
}
