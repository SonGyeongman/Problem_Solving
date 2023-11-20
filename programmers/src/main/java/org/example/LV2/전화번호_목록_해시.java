package org.example.LV2;

import java.util.Arrays;
import java.util.HashMap;

public class 전화번호_목록_해시 {
    public static void main(String[] args) {
        String[] hello = {"12", "31", "23", "24"};
        System.out.println(solution(hello));
    }

    public static boolean solution(String[] phone_book){
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<String, Integer>(){
            {
                for (int i = 0; i < phone_book.length; i++) {
                    put(phone_book[i], i);
                }
            }
        };

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0, j))){
                    answer = false;
                }
            }
        }
        return answer;
    }
}
