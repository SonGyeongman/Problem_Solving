package org.example.LV1;

import java.util.HashMap;
import java.util.HashSet;

public class 신고_결과_받기 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        solution(id_list, report, 2);
    }
    public static int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> result = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            HashSet<String> a = new HashSet<>();
            String[] r = report[i].split(" ");
            if(result.containsKey(r[1])){
                a = result.get(r[1]);
                a.add(r[0]);
                result.put(r[1],a);
            }else{
                a.add(r[0]);
                result.put(r[1],a);
            }
        }

        result.forEach((key, value) -> {
            if(value.size() >= k){
                for(String i : value){
                    for(int j = 0; j < id_list.length; j++){
                        if(i.equals(id_list[j])){
                            answer[j]++;
                        }
                    }
                }
            }
        });
        return answer;
    }
}
