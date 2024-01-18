package org.example.LV2;

import java.util.Arrays;

public class 가장_큰_수 {
    public static void main(String[] args) {
        // 10 6 2
        //
        int[] numbers = {6, 10, 2};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers){
        String answer = "";
        String[] num = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            num[i] = String.valueOf(numbers[i]);
        }

        

        return answer;
    }

    public static int big(int[] numbers, int left, int right, int max){
        if (left == right) {
            String result = "";
            for(int num : numbers){
                result += String.valueOf(num);
            }
            return Integer.valueOf(result);
        } else {
            for (int i = left; i <= right; i++) {
                swap(numbers, left, i);
                max = Math.max(big(numbers, left + 1, right, max), max);
                swap(numbers, left, i);
            }
        }
        return max;
    }

    public static void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
