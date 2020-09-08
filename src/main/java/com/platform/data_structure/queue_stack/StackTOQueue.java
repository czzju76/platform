package com.platform.data_structure.queue_stack;

import java.util.Stack;

/**
 * 问题：仅用栈结构实现队列结构
 * 解决问题：
 * 1、使用两个Stack（栈）来实现Queue的操作
 * 2、进队列操作，直接使用Stack的push方法
 * 3、出队列操作，将数据Stack的数据压入Help Stack，Help Stack再pop数据就是出队列操作
 */

public class StackTOQueue {
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int pushInt) {
            stackPush.push(pushInt);
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }
}
