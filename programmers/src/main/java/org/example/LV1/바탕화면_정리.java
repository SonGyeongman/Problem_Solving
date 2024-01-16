package org.example.LV1;

import java.util.ArrayList;
import java.util.Arrays;

public class 바탕화면_정리 {
    public static void main(String[] args) {
        String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        System.out.println(Arrays.toString(bestSolution(wallpaper)));
    }

    public static int[] bestSolution(String[] wallpaper){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }

    public static int[] solution(String[] wallpaper){
        int[] answer = new int[4];
        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    list.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if(i == 0){
                answer[0] = list.get(i)[0];
                answer[1] = list.get(i)[1];
                answer[2] = list.get(i)[0] + 1;
                answer[3] = list.get(i)[1] + 1;
            }else{
                if(answer[0] > list.get(i)[0]){
                    answer[0] = list.get(i)[0];
                }
                if(answer[1] > list.get(i)[1]){
                    answer[1] = list.get(i)[1];
                }
                if(answer[2] < list.get(i)[0] + 1){
                    answer[2] = list.get(i)[0] + 1;
                }
                if(answer[3] < list.get(i)[1] + 1){
                    answer[3] = list.get(i)[1] + 1;
                }
            }
            System.out.println(Arrays.toString(list.get(i)));
            System.out.println(Arrays.toString(answer));
        }

        return answer;
    }
}
