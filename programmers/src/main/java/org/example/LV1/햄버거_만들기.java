package org.example.LV1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class 햄버거_만들기 {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        ArrayDeque<Integer> test = new ArrayDeque<>();
        System.out.println(solution(ingredient));
    }

    public static int solution(int[] ingredient){
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i : ingredient){
            list.add(i);
            while(list.size() >= 4){
                if(list.get(list.size() - 4) == 1 &&
                        list.get(list.size() - 3) == 2 &&
                        list.get(list.size() - 2) == 3 &&
                        list.get(list.size() - 1) == 1){
                    for(int j = 4; j > 0; j--){
                        list.remove(list.size() - j);
                    }
                    answer++;
                }
                break;
            }
        }

        return answer;
    }
}
