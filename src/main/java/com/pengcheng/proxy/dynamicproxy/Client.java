package com.pengcheng.proxy.dynamicproxy;

/**
 * Created by IntelliJ IDEA.
 *
 * @version V1.0.0
 * @author: <a href="mailto:pengcheng.liu0828@gmail.com">pc.liu</a>.
 * @since: 2016/11/13.
 */
public class Client {

    public static void main(String[] args) {
        UserManagerProxy proxy = new UserManagerProxy();
        UserManager userManager = (UserManager) proxy.newProxyInstance(new UserManagerImpl());
        User user = new User("username_aaa", "pwd_aaa");
        userManager.add(user);
        userManager.find(user);
        userManager.update(new User("username_bbbb", "pwd_bbbb"));
        userManager.del(user);
    }
}
