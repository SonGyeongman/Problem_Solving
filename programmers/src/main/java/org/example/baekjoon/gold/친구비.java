package org.example.baekjoon.gold;

import java.util.Arrays;
import java.util.Stack;

public class 친구비 {
    public static int[] root;
    public static int[] cost;
    public static void main(String[] args) {
        /*
        * 학생수 = 5, 친구 관계수 = 3, 가지고 있는 돈 20
        * 친구비 = 10, 10, 20, 20, 30
        * 친구 관계 (1, 3), (2, 4), (5, 4)
        * 1.
        * */
        int[] f = {10, 10, 20, 20, 30};
        root = new int[5];
        for (int i = 0; i < root.length; i++) {
            root[i] = i + 1;
        }
        cost = new int[]{10, 10, 20, 20, 30};
        union(1,3);
        union(2, 4);
        union(4, 5);

        boolean[] check = new boolean[5];
        int cnt = 0;
        for(int i = 0; i < root.length; i++){
            int r = find(root[i]);
            if(!check[r - 1]) {
                cnt += cost[r - 1];
                check[r - 1] = true;
            }
            check[i] = true;
        }

        if(cnt > 20)
            System.out.println("Oh no");
        else
            System.out.println(cnt);
    }

    public static int find(int x){
        if(root[x - 1] == x)
            return x;
        else
            return find(root[x - 1]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(cost[x - 1] < cost[y - 1])
            root[y - 1] = x;
        else
            root[x - 1] = y;
    }
}
