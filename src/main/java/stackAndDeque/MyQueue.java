package stackAndDeque;

import java.util.Stack;

/**
 * 使用双栈模拟队列
 */
public class MyQueue {
    Stack<Integer> stackIn;//输入队列
    Stack<Integer> stackOut;//输出队列

    /**
     * 队列初始化
     */
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /**
     * 队尾添加元素
     * @param x
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * 队头元素出队列
     * @return
     */
    public int pop() {
        in2Out();
        return stackOut.pop();
    }

    /**
     * 输出队头元素但不出队列
     * @return
     */
    public int peek() {
        in2Out();
        return stackOut.peek();
    }

    /**
     * 判断是否队列为空
     * @return
     */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    /**
     * 输入栈倒序转入输出栈
     */
    private void in2Out(){
        //当输出栈为空的时候，将输入栈的元素倒序存入输出栈
        if(stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
    }
}
