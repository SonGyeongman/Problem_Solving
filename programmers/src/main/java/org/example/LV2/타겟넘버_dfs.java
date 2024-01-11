package org.example.LV2;

import java.util.Stack;

public class 타겟넘버_dfs {
    public static int answer = 0;
    public static void main(String[] args) {
        int[] numbers = {1,1,1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target){
        number(numbers, 0, target, 0);
        return answer;
    }

    public static void number(int[] num, int deep, int target, int result){
        if(num.length == deep){
            if(target == result){
                answer++;
            }
            return;
        }
        number(num, deep + 1, target, result + num[deep]);
        number(num, deep + 1, target, result - num[deep]);
    }

    public static void numberStack(int[] num, int deep, int target, int result){

    }
}
