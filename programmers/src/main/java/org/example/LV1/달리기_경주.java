package org.example.LV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class 달리기_경주 {
    public static void main(String[] args) {
        //m s k p m
        //m s k m p
        //k m s m p
        //k m m s p
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(solution(players, callings)));
    }

    public static String[] solution(String[] players, String[] callings){
        HashMap<String, Integer> playerMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }

        for(String calling : callings){
            int dic = playerMap.get(calling);

            playerMap.put(calling, dic - 1);
            playerMap.put(players[dic-1],dic);

            String temp = players[dic - 1];
            players[dic - 1] = players[dic];
            players[dic] = temp;
            System.out.println(Arrays.toString(players));
        }

        return players;
    }
}
