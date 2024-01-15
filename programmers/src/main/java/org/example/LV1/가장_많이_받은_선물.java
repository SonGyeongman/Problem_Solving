package org.example.LV1;

import java.util.Arrays;

public class 가장_많이_받은_선물 {
    public static void main(String[] args) {
        /*String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};*/
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        System.out.println(solution(friends, gifts));
    }

    public static int solution(String[] friends, String[] gifts){
        int answer = 0;
        int a = 0,b = 0;
        int[][] result = new int[friends.length][friends.length];
        int[] count = new int[friends.length];
        int[] submit = new int[friends.length];

        for(int i = 0; i < gifts.length; i++){
            String[] name = gifts[i].split(" ");
            for (int j = 0; j < friends.length; j++) {
                if(friends[j].equals(name[0])){
                    a = j;
                }
                if(friends[j].equals(name[1])){
                    b = j;
                }
            }
            result[a][b]++;
        }

        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                count[i] += result[i][j];
                count[i] -= result[j][i];
            }
        }

        for(int i = 0; i < result.length - 1; i++){
            for(int j = i; j < result[i].length; j++){
                if(i != j && result[i][j] == result[j][i]){
                    if (count[i] > count[j]) {
                        submit[i]++;
                    } else if(count[i] < count[j]){
                        submit[j]++;
                    }
                }else if(i != j && result[i][j] > result[j][i]){
                    submit[i]++;
                }else if(i != j && result[i][j] < result[j][i]) {
                    submit[j]++;
                }
            }
        }
        answer = Arrays.stream(submit).max().getAsInt();
        return answer;
    }
}
