package com.platform.pattern.Observer;

import java.util.*;

/**
 * @Title: Subject
 * @Description:
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/9/24 16:03
 */
public abstract class Subject {
    //
    private Set<Observer> observers = new HashSet<Observer>();
    protected String subjectState;

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void oNotify(){
        for (Observer o : observers) {
            o.update();
        }
    }

    public String getState(){
        return subjectState;
    }

}
