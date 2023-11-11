package org.example.LV2;

public class 카펫 {
    public static void main(String[] args) {
        int[] answer = solution(24,24);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
    /*
    * yellow가 약수만 올 수 있어 루트 yellow 만큼만 for문을 돌게 한다
    * */
    public static int[] solution(int brown, int yellow){
        int[] answer = new int[2];
        for(int i = 1; i <= Math.sqrt(yellow); i++){
            if(yellow % i == 0 && brown == (yellow / i) * 2 + 4 + i * 2) {
                answer[0] = yellow / i + 2;
                answer[1] = i + 2;
                break;
            }
        }
        return answer;
    }
}
