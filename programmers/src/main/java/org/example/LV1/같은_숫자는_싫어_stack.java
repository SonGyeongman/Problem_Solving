package org.example.LV1;

import java.util.Arrays;
import java.util.Stack;

public class 같은_숫자는_싫어_stack {
    public static void main(String[] args) {
        int[] a = {1,1,2,3,3,4};
        System.out.println(Arrays.toString(solution(a)));
    }

    public static int[] solution(int[] arr){
        Stack<Integer> stackInt = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(stackInt.isEmpty()){
                stackInt.push(arr[i]);
            }
            if(stackInt.peek() != arr[i]){
                stackInt.push(arr[i]);
            }
        }

        int[] answer = new int[stackInt.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stackInt.pop();
        }

        return answer;
    }
}
