package aaa;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        /*
          1.
          淘汰分数
          某比赛已经进入了淘汰赛阶段,已知共有n名选手参与了此阶段比赛，他们的得分分别是a_1,a_2….a_n,
          小美作为比赛的裁判希望设定一个分数线m，使得所有分数大于m的选手晋级，其他人淘汰。

          但是为了保护粉丝脆弱的心脏，小美希望晋级和淘汰的人数均在[x,y]之间。

          显然这个m有可能是不存在的，也有可能存在多个m，如果不存在，请你输出-1，
          如果存在多个，请你输出符合条件的最低的分数线。

          数据范围：1≤n≤50000 ，1≤x≤y≤n
         */
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = in.nextInt();
        }
        Arrays.sort(score);//对成绩数组进行排序
        int notOk = n - y;//未过线人数的最少值
        //题目需要的是最低分数线，即需要满足最多的过线人数，即理想状态下过线人数为y
        if(notOk > y){
            //最少未过线人数超过范围最大值，返回-1
            System.out.println(-1);
        } else if (notOk >= x) {
            //未过线人数在范围内，返回第一个未过线成员的分数
            System.out.println(score[n-y-1]);
        }else{
            //即notOk < x，未过线人数比x更少，通过减少过线人数（同时会增加未过线人数）即可
            System.out.println(score[x-1]);
        }
    }
}
