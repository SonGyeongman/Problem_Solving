package org.example.LV3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    public static void main(String[] args) {
        //["hot","dot","dog","lot","log","cog"] hit -> hot -> dot -> dog -> cog result = 4
        //1. begin이 target과 같지 않으면 answer = 0;
        //2. begin이 새로운 값이 들어가면 true로 변화하고 answer++한다.
        //3. target과 begin을 비교해서 하나만 맞은 경우만 check true를 넣는다
    }

    public static int solution(String begin, String target, String[] words){
        int answer = 0;
        boolean[] check = new boolean[words.length];
        for(int i = 0; i < words.length; i++){
            if(!check[i]){
                dfs(words, i, target, check, begin);
            }
        }
        return answer;
    }

    public static boolean[] dfs(String[] words, int n, String target, boolean[] check, String begin){

        for(int j = 0; j < target.length(); j++){

        }

        return check;
    }
}
