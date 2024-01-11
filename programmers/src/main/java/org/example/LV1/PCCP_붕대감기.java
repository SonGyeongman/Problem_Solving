package org.example.LV1;

public class PCCP_붕대감기 {
    public static void main(String[] args) {
        int[] bandage = {5,1,5};
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        System.out.println(solution(bandage, 30, attacks));
    }

    public static int solution(int[] bandage, int health, int[][] attacks){
        int answer = health;
        int sec = 0;
        for (int i = 0; i < attacks.length; i++) {
            answer = answer - attacks[i][1];
            if(answer <= 0){
                return -1;
            }
            if(i == attacks.length - 1){
                return answer;
            }
            sec = attacks[i+1][0] - attacks[i][0] - 1;
            answer = answer + sec / bandage[0] * bandage[2] + sec * bandage[1];
            if(answer > health){
                answer = health;
            }
        }
        return answer;
    }
}
