package org.example.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class 색종이_만들기 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int width = s1.nextInt();
        int[][] paper = new int[width][width];
        for (int i = 0; i < width; i++) {
            for(int j = 0; j < width; j++){
                paper[i][j] = s1.nextInt();
            }
        }

        int[] result = solution(width, paper);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] solution(int width, int[][] paper){
        int[] answer = new int[2];
        String result = divide(paper, 0, 0, width);
        for(int i = 0; i < result.length(); i++){
            if(result.charAt(i) == '0'){
                answer[0] += 1;
            }else{
                answer[1] += 1;
            }
        }
        return answer;
    }

    public static String divide(int[][] paper, int w, int h, int size){
        int sum = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                sum += paper[i + h][j + w];
            }
        }
        String result = "";
        if(sum == 0){
            return "0";
        }else if(sum == size * size){
            return "1";
        } else{
            int half = size/2;
            result += divide(paper, w, h, half);
            result += divide(paper, w + half, h, half);
            result += divide(paper, w, h + half, half);
            result += divide(paper, w + half, h + half, half);
        }
        return result;
    }

}
