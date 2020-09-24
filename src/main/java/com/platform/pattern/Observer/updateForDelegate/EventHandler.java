package com.platform.pattern.Observer.updateForDelegate;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title: EventHandler
 * @Description:
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/9/24 17:05
 */
public class EventHandler {
    private Set<Event> objects;

    public EventHandler()
    {
        objects = new HashSet<Event>();
    }

    public void addEvent(Object object, String methodName, Object...args)
    {
        objects.add(new Event(object, methodName, args));
    }

    public void oNotify() throws Exception
    {
        for (Event event : objects)
        {
            event.invoke();
        }
    }

}
