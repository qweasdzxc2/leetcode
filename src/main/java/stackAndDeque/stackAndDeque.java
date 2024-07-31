package stackAndDeque;

import java.util.ArrayDeque;

public class stackAndDeque {
    public static void main(String[] args) {
        /**
         * 使用ArrayDeque实现栈的模拟
         */
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //栈元素的压入：
        stack.addFirst(1);

        System.out.println(stack);
    }
}
