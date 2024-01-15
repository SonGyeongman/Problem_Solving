package org.example.LV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class 개인정보_수집_유효기간 {
    //"2009.12.31", ["A 13"], ["2008.11.03 A"]
    public static void main(String[] args) {
        String today = "2009.12.31";
        String[] terms = {"A 13"};
        String[] privacies = {"2008.11.03 A"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));

        for(int i = 0; i < 50; i++){
            int sum = i % 12 == 0 ? 12 : i % 12;
            System.out.println(i + " " + sum);
        }
    }

    public static int[] solution(String today, String[] terms, String[] privacies){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, String> termsMap = new HashMap<>();
        for(String s : terms){
            String[] divide = s.split(" ");
            termsMap.put(divide[0], divide[1]);
        }

        for(int i = 1; i < privacies.length+1; i++){
            String[] divide = privacies[i-1].split(" ");
            String[] yearMonth = divide[0].split("\\.");
            String[] todayArray = today.split("\\.");

            int year = parseInt(yearMonth[0]);
            int month = parseInt(yearMonth[1]);
            int sum = month + parseInt(termsMap.get(divide[1]));
            if(sum > 12){
                yearMonth[1] = String.valueOf(sum % 12 == 0 ? 1 : sum % 12);
                yearMonth[0] = String.valueOf(sum % 12 == 0 ? year + sum / 12 - 1 : year + sum / 12);
            }else {
                yearMonth[1] = String.valueOf(sum);
            }

            System.out.println(yearMonth[1]);

            if(parseInt(todayArray[0]) > parseInt(yearMonth[0])){
                answer.add(i);
            }else if(parseInt(todayArray[0]) == parseInt(yearMonth[0]) &&
                    parseInt(todayArray[1]) > parseInt(yearMonth[1])){
                answer.add(i);
            }else if(parseInt(todayArray[0]) == parseInt(yearMonth[0]) &&
                    parseInt(todayArray[1]) == parseInt(yearMonth[1]) &&
                    parseInt(todayArray[2]) > parseInt(yearMonth[2]) - 1){
                answer.add(i);
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
