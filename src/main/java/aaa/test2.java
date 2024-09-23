package aaa;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        /**
         * 我们称一个长度为n的序列为正则序列，当且仅当该序列是一个由1~n组成的排列，
         * 即该序列由n个正整数组成，取值在[1,n]范围，且不存在重复的数，同时正则序列不要求排序
         *
         * 有一天小团得到了一个长度为n的任意序列s，他需要在有限次操作内，将这个序列变成一个正则序列，
         * 每次操作他可以任选序列中的一个数字，并将该数字加一或者减一。
         *
         * 请问他最少用多少次操作可以把这个序列变成正则序列？
         *
         * 数据范围：
         * 1≤n≤20000 ，
         * 0≤abs(s^i)≤10000
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
        Arrays.sort(array);//排序
        //贪心算法思路
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += Math.abs(array[i] - (i+1));
        }
        System.out.println(sum);
    }
}
