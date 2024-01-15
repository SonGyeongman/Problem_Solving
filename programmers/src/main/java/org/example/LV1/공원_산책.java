package org.example.LV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 공원_산책 {
    public static void main(String[] args) {
        //  ["SOOXO", "OOOXO", "OXOOO", "XOOOO"], ["E 2", "S 2", "W 2", "S 1", "W 1"]
        String[] park = {"OOOOO", "OOOOO", "OOSOO", "OOOOO", "OOOOO"};
        String[] routes = {"E 3", "W 3", "S 3", "N 3", "E 2", "E 1", "W 4", "W 1", "S 2", "S 1", "N 4", "N 1"};
        System.out.println(Arrays.toString(solution(park, routes)));
    }

    public static int[] solution(String[] park, String[] routes){
        int[] answer = new int[2];
        HashMap<String, Integer> routeMap = new HashMap<>();
        routeMap.put("E", 1);
        routeMap.put("N", -1);
        routeMap.put("S", 1);
        routeMap.put("W", -1);

        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        for(String r : routes){
            String[] move = r.split(" ");
            int[] temp = answer.clone();
            for(int i = 0; i < Integer.parseInt(move[1]); i++){
                if(move[0].equals("E") || move[0].equals("W")){
                    answer[1] += routeMap.get(move[0]);
                }

                if(move[0].equals("S") || move[0].equals("N")){
                    answer[0] += routeMap.get(move[0]);
                }

                if(answer[1] >= park[0].length() ||
                        answer[0] >= park.length ||
                        answer[1] < 0 ||
                        answer[0] < 0 ||
                        park[answer[0]].charAt(answer[1]) == 'X'){
                    answer = temp.clone();
                    break;
                }
            }
        }

        return answer;
    }
}
