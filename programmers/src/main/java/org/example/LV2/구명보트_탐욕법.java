package org.example.LV2;

import java.util.Arrays;

public class 구명보트_탐욕법 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
    }

    public static int solution(int[] people, int limit){
        int answer = 0;
        Arrays.sort(people);
        int count = 0;
        for(int i = people.length - 1; i >= count; i--){
            if(people[i] + people[count] <= limit){
                answer++;
                count++;
            }else{
                answer++;
            }
        }
        return answer;
    }
}
