package org.example.baekjoon.bronze;

import java.util.Scanner;

public class 재귀의_귀재 {
    /* 팰린드롬이란, 앞에서부터 읽었을 때와 뒤에서부터 읽었을 때가 같은 문자열을 말한다.
     * 팰린드롬의 예시로 AAA, ABBA, ABABA 등이 있고, 팰린드롬이 아닌 문자열의 예시로 ABCA, PALINDROME 등이 있다.
     *
     * 나의 풀이 방식
     * 1. 첫 문자 위치와 마지막 문자 위치 값을 매개 변수로 전달한다.
     * 2. 첫 문자 위차 + 1 , 마지막 문자 위치 -1을 매개변수르 전달하는데 첫 문자 위치 > 마지막 문자 위치이면 return 1;
     * 3. 만약 2번까지 실행 전에 문자가 다르면 return 0;
     * */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        String[] answer = new String[count];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = s.next();
        }

        for(String a : answer){
            System.out.println(recursion(a, 0, a.length() - 1) + " " + count(a, 0, a.length() - 1));
        }
    }

    public static int solution(String s){
        int answer = 0;
        answer = recursion(s, 0, s.length() - 1);
        return answer;
    }

    public static int recursion(String s, int l, int r){
        if(l > r) return 1;
        if(s.charAt(l) != s.charAt(r)) return 0;
        return recursion(s, l + 1, r - 1);
    }

    public static int count(String s, int l, int r){
        if(l >= r || s.charAt(l) != s.charAt(r)) return 1;
        int answer = 0;
        answer += count(s, l + 1, r - 1) + 1;
        return answer;
    }

}
