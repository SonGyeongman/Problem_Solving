package org.example.LV2;

import java.util.Arrays;

public class 체육복_탐욕법 {
    public static void main(String[] args) {
        int[] lost = {1, 2};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(5, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve){
        int answer = lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                 if(lost[i] == reserve[j]){
                     answer--;
                     lost[i] = -1;
                     reserve[j] = -1;
                 }
            }
        }

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]){
                    answer--;
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }
        return n - answer;
    }
}
