package org.example.LV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 데이터_분석_PCCE {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        int[][] result = solution(data, ext, val_ext, sort_by);
        for(int[] a : result){
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by){
        ArrayList<int[]> result = new ArrayList<>();
        HashMap<String, Integer> dataName = new HashMap<>();
        dataName.put("code", 0);
        dataName.put("date", 1);
        dataName.put("maximum", 2);
        dataName.put("remain", 3);

        for(int[] d : data){
            if(d[dataName.get(ext)] < val_ext){
                result.add(d);
            }
        }
        int[][] answer = new int[result.size()][4];

        while(result.size() > 0){
            int temp = 0;
            for(int i = 1; i < result.size(); i++){
                if(result.get(temp)[dataName.get(sort_by)] > result.get(i)[dataName.get(sort_by)]){
                    temp = i;
                }
            }
            answer[answer.length - result.size()] = result.remove(temp);
        }

        return answer;
    }
}
