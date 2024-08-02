package stackAndDeque;

import java.util.*;

public class stackAndDeque {
    public static void main(String[] args) {
        /**
         * 使用ArrayDeque实现栈的模拟，栈不提供走访和和迭代遍历
         */
        simulateStack();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        for (int i : maxSlidingWindow(nums, 3)) {
            System.out.print(i+" ");
        }

    }

    /**
     * 双端队列模拟栈
     */
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

    /**
     * leetcode 239
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        //队列存储的是数组元素的索引下标
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int index = 0;
        int[] result = new int[length - k + 1];
        for(int i = 0; i < length; i++){
            //若队列中队首元素范围不在[i - k + 1, i]，则说明已经不在滑动窗口中，不能作为窗口最大值，应当移出队列
            while(!deque.isEmpty() && deque.peekFirst() < i-k+1){
                deque.removeFirst();
            }
            //通过从后往前遍历队列元素
            //当数组元素大于遍历到的元素时，依次移除队列元素，直到队列中的元素都大于将要存入的数组元素
            //当数组元素小于队列最小元素（即队列尾的元素），直接加入队尾即可
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.removeLast();
            }
            deque.offerLast(i);
            //因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(i >= k - 1){
                result[index++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 1)+1);
        }
        // 根据 value 进行排序
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}
