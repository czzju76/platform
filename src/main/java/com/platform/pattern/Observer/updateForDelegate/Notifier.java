package com.platform.pattern.Observer.updateForDelegate;

/**
 * @Title: Notifier
 * @Description:
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/9/24 17:10
 */
public abstract class Notifier {
    private EventHandler eventHandler = new EventHandler();

    public EventHandler getEventHandler()
    {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler)
    {
        this.eventHandler = eventHandler;
    }

    public abstract void addListener(Object object,String methodName, Object...args);

    public abstract void oNotify();

}
