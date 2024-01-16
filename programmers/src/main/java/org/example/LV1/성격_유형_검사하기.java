package org.example.LV1;

import java.util.HashMap;

public class 성격_유형_검사하기 {
    public static void main(String[] args) {
        /*
        * 1번 지표	라이언형(R), 튜브형(T)
        * 2번 지표	콘형(C), 프로도형(F)
        * 3번 지표	제이지형(J), 무지형(M)
        * 4번 지표	어피치형(A), 네오형(N)
        * */

        /*
        * 매우 비동의	어피치형 3점
비동의	어피치형 2점
약간 비동의	어피치형 1점
모르겠음	어떤 성격 유형도 점수를 얻지 않습니다
약간 동의	네오형 1점
동의	네오형 2점
매우 동의	네오형 3점
        * */
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }

    public static String solution(String[] survey, int[] choices){
        String answer = "";
        int[] score = {3,2,1,0,1,2,3};
        String[] type = {"RT", "CF", "JM", "AN"};
        HashMap<Character, Integer> mbti = new HashMap<>();
        mbti.put('R', 0);
        mbti.put('T', 0);
        mbti.put('C', 0);
        mbti.put('F', 0);
        mbti.put('J', 0);
        mbti.put('M', 0);
        mbti.put('A', 0);
        mbti.put('N', 0);

        for(int i = 0; i < survey.length; i++){
            int temp = choices[i] - 1;
            if(temp < 3){
                mbti.put(survey[i].charAt(0), mbti.get(survey[i].charAt(0)) + score[temp]);
            }

            if(temp > 3){
                mbti.put(survey[i].charAt(1), mbti.get(survey[i].charAt(1)) + score[temp]);
            }
        }

        for(String t : type){
            if(mbti.get(t.charAt(0)) > mbti.get(t.charAt(1))){
                answer += t.charAt(0);
            }else if(mbti.get(t.charAt(0)) < mbti.get(t.charAt(1))){
                answer += t.charAt(1);
            }else{
                answer += (int)t.charAt(0) < (int)t.charAt(1) ? t.charAt(0) : t.charAt(1);
            }
        }

        return answer;
    }
}
