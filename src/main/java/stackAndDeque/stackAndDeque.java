package stackAndDeque;

import java.util.ArrayDeque;

public class stackAndDeque {
    public static void main(String[] args) {
        /**
         * 使用ArrayDeque实现栈的模拟，栈不提供走访和和迭代遍历
         */
        simulateStack();
    }

    private static void simulateStack(){
        //本质是双端队列，模拟时看作出入口为同一个
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        /*
        栈元素的压入：addFirst(),offerFirst()
        */
        stack.addFirst(1);//无返回值，栈满抛出异常
        stack.offerFirst(2);//返回值为压入成功与否的boolean类型值
        stack.addFirst(3);
        System.out.println(stack);
        /*
        栈顶元素出栈:removeFirst(),poolFirst()
         */
        System.out.println("移除" + stack.removeFirst());//返回值为移除的元素，栈空抛出异常
        System.out.println("移除" + stack.pollFirst());//返回值为移除的元素，栈空返回null
        /*
        检索栈顶元素但不出栈：peekFirst()
         */
        System.out.println("当前栈顶元素"+stack.peekFirst());
        System.out.println(stack);
    }
}
