package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列模拟栈
 * 只能使用队列的标准操作 ——
 * 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 */
public class MyStack {
    Queue<Integer> queue;
    /**
     * 栈初始化
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * 元素压入栈顶
     * @param x
     */
    public void push(int x) {
        queue.add(x);
    }

    /**
     * 栈顶元素出栈
     * @return
     */
    public int pop() {
        //将队列中元素从最前面的开始依次移动到队尾，未移动的最后那个元素出队列
        int size = queue.size() - 1;
        while(size > 0){
            queue.add(queue.poll());
            size--;
        }
        return queue.poll();
    }

    /**
     * 获取栈顶元素但不出栈
     * @return
     */
    public int top() {
        int size = queue.size() - 1;
        while(size > 0){
            queue.add(queue.poll());
            size--;
        }
        int result = queue.poll();
        queue.add(result);
        return result;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
