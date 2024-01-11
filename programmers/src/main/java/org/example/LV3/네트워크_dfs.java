package org.example.LV3;

import java.util.Arrays;

public class 네트워크_dfs {
    public static void main(String[] args) {
        int[][] computers = {{1,1,0,0},{1,1,1,0},{0,1,1,0},{0,0,0,1}};
        System.out.println(solution(4, computers));
    }

    public static int solution(int n, int[][] computers){
        int answer = 0;
        boolean[] check = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!check[i]){
                dfs(computers, i, check);
                answer++;
            }
        }
        System.out.println(Arrays.toString(check));
        return answer;
    }

    public static boolean[] dfs(int[][] computers, int n, boolean[] check){
        check[n] = true;
        for(int j = 0; j < computers[n].length; j++){
            if(j != n && computers[n][j] == 1 && !check[j]){
                check = dfs(computers, j, check);
            }
        }
        return check;
    }
}
