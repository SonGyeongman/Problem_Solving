package org.example.Algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 재귀함수 {
    public static void main(String[] args) {
        // 문제1 - 0부터 7개의 원소로 4개의 원소의 각각 다른 원소를 가지게 만들어보세요
        //solution1(7, new ArrayList<>(), 4);

        // 문제2 - 0부터 7개의 원소를 합이 7인 4개의 원소의 각각 다른 원소를 가지게 만들어보세요.
        //solution2(7, new ArrayList<>(), 4, 7);

        // 문제3 - 0부터 7개의 원소를 합이 7인 4개의 원소의 갯수를 구하시오
        int a = solution3(7, new ArrayList<>(), 4, 7, 0);
        System.out.println(a);

    }

    public static void solution1(int n, ArrayList<Integer> list, int count){
        if(count == 0){
            for(int i : list){
                System.out.print(i);
            }
            System.out.println();
            return;
        }
        int next = list.isEmpty() ? 0 : list.get(list.size() - 1) + 1;
        for(int i = next; i < n; i++){
            list.add(i);
            solution1(n, list, count - 1);
            list.remove(list.size() - 1);
        }
    }

    public static void solution2(int n, ArrayList<Integer> list, int count, int sum){
        if(count == 0){
            int result = 0;
            for(int i : list){
                result += i;
            }
            if(result == sum){
                for(int i : list){
                    System.out.print(i + " ");
                }
                System.out.println(" ");
            }
            return;
        }
        int next = list.isEmpty() ? 0 : list.get(list.size() - 1) + 1;
        for(int i = next; i < n; i++){
            list.add(i);
            solution2(n, list, count - 1, sum);
            list.remove(list.size() - 1);
        }
    }

    public static int solution3(int n, ArrayList<Integer> list, int count, int sum, int answer){
        if(count == 0){
            int result = 0;
            for(int i : list){
                result += i;
            }
            return result == sum ? 1 : 0;
        }
        int next = list.isEmpty() ? 0 : list.get(list.size() - 1) + 1;
        for(int i = next; i < n; i++){
            list.add(i);
            answer += solution3(n, list, count - 1, sum, 0);
            list.remove(list.size() - 1);
        }
        return answer;
    }
}
