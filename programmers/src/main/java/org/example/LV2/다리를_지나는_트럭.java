package org.example.LV2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public static void main(String[] args) {
        System.out.println(solution(10, 100, new int[]{50, 30, 10, 10, 30, 10, 40}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int w = 0;
        int i = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int num : truck_weights) {
            q.add(num);
        }

        while (!q.isEmpty()) {
            w = w - q.peek();
            if (w >= 0) {
                if (i == 0) {
                    answer += bridge_length;
                } else {
                    answer++;
                }
                q.poll();
                i++;
            }else{
                w = weight;
                i = 0;
            }
        }

        return answer + 1;
    }
}
