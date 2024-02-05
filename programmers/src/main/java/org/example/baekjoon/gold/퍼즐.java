package org.example.baekjoon.gold;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 퍼즐 {

    static int[] x = {-1, 0, 1, 0};
    static int[] y = {0, -1, 0, 1};
    public static void main(String[] args) {
        StringBuilder puzzle = new StringBuilder();
        Scanner s1 = new Scanner(System.in);
        for(int i = 0; i < 9; i++){
            puzzle.append(s1.nextInt());
        }
        System.out.println(solution(puzzle.toString()));
    }

    public static int solution(String puzzle){
        int answer = -1;
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();

        q.add(puzzle);
        map.put(puzzle, 0);

        while(!q.isEmpty()){
            String num = q.poll();
            int position = num.indexOf('0');
            int xx = position % 3;
            int yy = position / 3;
            for(int i = 0; i < 4; i++){
                StringBuilder s = new StringBuilder(num);
                int X = xx + x[i];
                int Y = yy + y[i];
                if(X >= 0 && X < 3 && Y >= 0 && Y < 3){
                    char temp = s.charAt(X + Y * 3);
                    s.setCharAt(position, temp);
                    s.setCharAt(X+Y*3, '0');
                    String result = s.toString();
                    if(!map.containsKey(result)){
                        map.put(result, map.get(num) + 1);
                        q.add(result);
                    }
                }
            }
            if(map.containsKey("123456780")){
                return map.get("123456780");
            }
        }
        return answer;
    }
}
