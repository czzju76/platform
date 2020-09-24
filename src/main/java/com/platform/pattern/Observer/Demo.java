package com.platform.pattern.Observer;

/**
 * @Title: Demo
 * @Description:
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/9/24 16:48
 */
public class Demo {

    private static class ConcreteSubject1 extends Subject
    {
        public void setState(String state){
            this.subjectState = state;
        }
    }

    private static class ConcreteObserver1 implements Observer
    {
        private Subject subject;

        public ConcreteObserver1(Subject subject)
        {
            this.subject = subject;
        }

        public void update() {
            System.out.println("ConcreteObserver1: "+subject.getState());
        }
    }

    private static  class ConcreteObserver2 implements Observer
    {
        private Subject subject;

        public ConcreteObserver2(Subject subject)
        {
            this.subject = subject;
        }

        public void update() {
            System.out.println("ConcreteObserver2: "+subject.getState());
        }
    }

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject1();
        ((ConcreteSubject1) subject).setState("I am real subject.");

        subject.attach(new ConcreteObserver1(subject));
        subject.attach(new ConcreteObserver2(subject));

        subject.oNotify();
    }
}
