package org.example.LV2;

import java.util.*;

public class 기능개발_stack {
    public static void main(String[] args) {
        int[] progress = {99,98};
        int[] speed = {1,1};
        System.out.println(Arrays.toString(solution(progress, speed)));
    }
    public static int[] solution(int[] progresses, int[] speeds){
        int[] answer = {};
        Queue<Integer> queueInt = new LinkedList<>();
        ArrayList<Integer> sum = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            queueInt.add(num(progresses[i], speeds[i]));
        }
        while(!queueInt.isEmpty()){
            int count = 1;
            int first = queueInt.poll();

            while(!queueInt.isEmpty() && queueInt.peek() <= first){
                count++;
                queueInt.poll();
            }
            sum.add(count);
        }
        answer = new int[sum.size()];
        for (int i = 0; i < sum.size(); i++) {
            answer[i] = sum.get(i);
        }
        return answer;
    }

    public static int num(int progress, int speed){
        return (100 - progress) % speed == 0 ? (100 - progress) / speed : (100 - progress) / speed + 1;
    }
}
