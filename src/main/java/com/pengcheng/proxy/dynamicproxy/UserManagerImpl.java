package com.pengcheng.proxy.dynamicproxy;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by IntelliJ IDEA.
 *
 * @version V1.0.0
 * @author: <a href="mailto:pengcheng.liu0828@gmail.com">pc.liu</a>.
 * @since: 2016/11/13.
 */
public class UserManagerImpl implements UserManager {
    public boolean add(User user) {
        System.out.println("UserManagerImpl.add called!");
        return false;
    }

    public void del(User user) {
        System.out.println("UserManagerImpl.del called!");
    }

    public User find(User user) {
        System.out.println("UserManagerImpl.del called!");
        Long userId = User.genId();
        return new User(StringUtils.join("userName_", userId), StringUtils.join("passwd_", userId));
    }

    public boolean update(User user) {
        System.out.println("UserManagerImpl.update called!");
        return false;
    }
}
