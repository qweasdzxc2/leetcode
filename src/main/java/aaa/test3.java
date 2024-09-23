package aaa;

import java.util.Arrays;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        /*
        贪心算法：硬币问题,贪心算法并不能总有最优解
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//硬币个数
        int money = in.nextInt();//目标金额
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = in.nextInt();
        }
        Arrays.sort(coins);
        int count = 0;
        for(int i = coins.length - 1; i >= 0; i--){
            while (money >= coins[i]){
                money -= coins[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
