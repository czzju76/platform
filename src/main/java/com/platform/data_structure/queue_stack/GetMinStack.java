package com.platform.data_structure.queue_stack;

import java.util.Stack;

/**
 *  问题：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返 回栈中最小元素的操作。
 *  要求：
 *  1．pop、push、getMin操作的时间复杂度都是O(1)。
 *  2．设计的栈类型可以使用现成的栈结构。
 *
 *
 *  解决方案：
 *  使用两个Stack，一个Stack压入数据，另外一个Stack压入当前栈中的最小值（第一个值为数据值，第二个值与之前最小值
 *  比较得到新的最小值压入栈，之后以此类推）
 *  注意：Queue（队列）没有这么好的性质，push数据入stack时，需要O(N)时间复杂度
 *
 */

public class GetMinStack {
    public static class MinStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MinStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getmin()) {
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }
}
