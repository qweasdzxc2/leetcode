package mihoyo;

import java.util.*;

/**
 * 第一题
 */
public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //读入数组长度
        int length = scanner.nextInt();

        //读入数组
        Long[] array = new Long[length];
        for(int i = 0; i < length; i++){
            array[i] = scanner.nextLong();
        }

        //初始化数组价值为最小值
        long maxMultiply = Long.MIN_VALUE;
        //遍历数组元素
        for (int i = 0; i < length - 1; i++) {
            //计算当前相邻对的乘积
            Long currentMultiply = array[i] * array[i+1];
            maxMultiply = Math.max(maxMultiply,currentMultiply);
            //计算执行交换后的新乘积
            if(i > 0){
                Long tempMultiply = array[i - 1] * array[i + 1];
                maxMultiply = Math.max(maxMultiply, tempMultiply);
            }
            if(i < length - 2){
                Long tempMultiply = array[i] * array[i+2];
                maxMultiply = Math.max(maxMultiply, tempMultiply);
            }
        }
        System.out.print(maxMultiply);
    }
}
