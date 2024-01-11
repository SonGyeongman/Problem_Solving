package org.example.LV2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리_bfs {
    public static void main(String[] args) {
        //int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int[][] maps = {{1},{1}};
        System.out.println(solution(maps));

    }

    public static int solution(int[][] maps){
        int answer = 0;
        Queue<int[]> bfs = new LinkedList<>();
        int[][] count = new int[maps.length][maps[0].length];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        bfs.add(new int[]{0,0});
        count[0][0] = 1;

        while(!bfs.isEmpty()){
            int[] position = bfs.poll();

            for(int i = 0; i < 4; i++){
                int nx = position[1] + dx[i];
                int ny = position[0] + dy[i];
                if(nx >= 0 && nx < maps[0].length && maps[position[0]][nx] == 1 && count[position[0]][nx] == 0){
                    count[position[0]][nx] = count[position[0]][position[1]] + 1;
                    bfs.add(new int[]{position[0], nx});
                }
                if(ny >= 0 && ny < maps.length && maps[ny][position[1]] == 1 && count[ny][position[1]] == 0) {
                    count[ny][position[1]] = count[position[0]][position[1]] + 1;
                    bfs.add(new int[]{ny, position[1]});
                }
            }
            for(int[] a : count){
                for(int i : a){
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            if(count[maps.length-1][maps[0].length-1] > 0){
                break;
            }
        }
        answer = count[maps.length-1][maps[0].length-1];
        return answer == 0 ? -1 : answer;
    }
}
