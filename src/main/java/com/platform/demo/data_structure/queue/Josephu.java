package com.platform.demo.data_structure.queue;

import com.platform.data_structure.queue.CircleQueue;

/**
 * Josephu Question
 * 约瑟夫问题：设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，
 * 数到m 的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，
 * 直到所有人出列为止，由此产生一个出队编号的序列。
 */
public class Josephu {

    public static void main(String[] args) {
        resolution(10,3);
    }

    public static void resolution(int n, int k){
        if(n<1 || k < 1) {
            System.out.println("输入参数有误！");
            return;
        }
        CircleQueue<Integer> circleQueue = new CircleQueue<Integer>(1);
        for (int i = 0; i < n; i++) {
            circleQueue.put(i+1);
        }
        circleQueue.setStep(k);
        circleQueue.connect();
        circleQueue.start();
        int num = 0;
        while(true){
            if(circleQueue.size()==0)
                break;
            num = circleQueue.moveAndTake();
            System.out.println("child id: "+num);
        }
    }
}
