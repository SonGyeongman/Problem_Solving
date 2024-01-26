package org.example.baekjoon.silver;

import java.util.List;

public class 로또 {
    public static void main(String[] args) {

    }

    public static void lotto(int[] num, List<Integer> result){
        if(result.size() > 6){
            for(int i : result){
                System.out.print(i + " ");
            }
        }
        int next = result.isEmpty() ? 0 : result.size();
        for(int i = next; i < num.length; i++){
            result.add(num[i]);
            lotto(num, result);
            result.remove(result.size() - 1);
        }
    }
}
