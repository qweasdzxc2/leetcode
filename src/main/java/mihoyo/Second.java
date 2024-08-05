package mihoyo;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取商品个数n，背包容量m，互斥关系组数k
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] volume = new int[n];
        int[] value = new int[n];

        // 读取每个商品的体积和价值
        for (int i = 0; i < n; i++) {
            volume[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        // 读取互斥关系
        boolean[][] conflict = new boolean[n][n];
        for (int i = 0; i < k; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            conflict[a][b] = true;
            conflict[b][a] = true;
        }

        scanner.close();

        // 动态规划，状态压缩
        int[] dp = new int[1 << n];

        // 遍历所有状态
        for (int mask = 1; mask < (1 << n); mask++) {
            int totalVolume = 0;
            int totalValue = 0;
            boolean valid = true;

            // 检查每个商品是否在当前状态中，并计算总体积和总价值
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    totalVolume += volume[i];
                    totalValue += value[i];
                    // 检查与之前商品的互斥关系
                    for (int j = 0; j < i; j++) {
                        if ((mask & (1 << j)) != 0 && conflict[i][j]) {
                            valid = false;
                            break;
                        }
                    }
                }
                if (!valid) break;
            }

            // 如果状态有效且总体积不超过背包容量，则更新dp数组
            if (valid && totalVolume <= m) {
                dp[mask] = totalValue;
                for (int subMask = mask; subMask > 0; subMask = (subMask - 1) & mask) {
                    dp[mask] = Math.max(dp[mask], dp[subMask] + dp[mask ^ subMask]);
                }
            }
        }

        // 寻找最大值
        int maxValue = 0;
        for (int thisValue : dp) {
            maxValue = Math.max(maxValue, thisValue);
        }

        System.out.println(maxValue);
    }
}
