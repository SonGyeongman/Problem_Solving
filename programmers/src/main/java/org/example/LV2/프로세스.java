package org.example.LV2;

import java.util.*;

public class 프로세스 {
    public static void main(String[] args) {
        int[] p = {1,1,9,1,1,1};
        PriorityQueue<Integer> p1 = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < p.length; i++) {
            p1.add(p[i]);
        }
        System.out.println(p1);
        System.out.println(solution(p, 0));
    }

    public static int solution(int[] priorities, int location){
        //[2,1,3,2] 2 [2,2,2,1,1]
        int answer = 0;
        location = location + 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : priorities){
            pq.add(num);
        }

        while(!pq.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(pq.peek() != null && priorities[i] == pq.peek()){
                    pq.poll();
                    answer++;
                    if(answer == location){
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}
