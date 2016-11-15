package com.pengcheng.proxy.staticproxy;

/**
 * Created by IntelliJ IDEA.
 *
 * @version V1.0.0
 * @author: <a href="mailto:pengcheng.liu0828@gmail.com">pc.liu</a>.
 * @since: 2016/11/13.
 */
public class ProxySubject implements Subject {

    private RealSubject subject;

    public ProxySubject(RealSubject subject) {
        this.subject = subject;
    }

    public ProxySubject() {
    }


    public void setSubject(RealSubject subject) {
        this.subject = subject;
    }

    public void request() {
        preRequest();
        if (this.subject == null) {
            this.subject = new RealSubject();
        }
        this.subject.request();
        postRequest();
    }

    private void preRequest() {
        System.out.println("Pre Request.");
    }
    private void postRequest(){
        System.out.println("Post Request");
    }

    private class RealSubject implements Subject {
        public void request() {
            System.out.println("RealSubject request do!");
        }
    }
}



