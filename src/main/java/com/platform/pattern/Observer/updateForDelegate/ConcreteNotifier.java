package com.platform.pattern.Observer.updateForDelegate;

/**
 * @Title: ConcreteNotifier
 * @Description:
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/9/24 17:12
 */
public class ConcreteNotifier extends Notifier {

    public void addListener(Object object, String methodName, Object... args) {
        this.getEventHandler().addEvent(object, methodName, args);
    }

    public void oNotify() {
        try {
            this.getEventHandler().oNotify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
