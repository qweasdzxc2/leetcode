package aaa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        /*
        动态规划：背包问题
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//商品个数
        int capacity = in.nextInt();//背包容量
        Scanner options = new Scanner(System.in);
        int[] weight = new int[n];//重量
        int[] value = new int[n];//价值
        for (int i = 0; i < n; i++) {
            weight[i] = options.nextInt();
            value[i] = options.nextInt();
        }

        System.out.println(completeKnapsack(n,capacity,weight,value));
    }
    public static int completeKnapsack(int n, int capacity, int[] weight, int[] value){
        int[] dp = new int[capacity + 1];//+1能够确保数组遍历到背包可用的最大容量

        //遍历所有物品
        for (int i = 0; i < n; i++) {
            //遍历背包容量，从最大容量开始，到当前物品重量为止即可
            for(int j = capacity; j >= weight[i]; j--){
                //dp[j - weights[i]] + values[i] 是放入物品 i 后的总价值，
                //这个值包括放入该物品后剩余容量的最大价值加上该物品的价值。
                dp[j] = Math.max(dp[j], dp[j - weight[i]]+ value[i]);
            }
        }
        return dp[capacity];
    }
}
