package org.example.LV2;

import java.util.ArrayList;
import java.util.Arrays;

public class 영어_끝말잇기 {
    /*
    * 1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기를 하고 있습니다. 영어 끝말잇기는 다음과 같은 규칙으로 진행됩니다.
    * 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
    * 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
    * 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
    * 이전에 등장했던 단어는 사용할 수 없습니다.
    * 한 글자인 단어는 인정되지 않습니다.
    * */
    public static void main(String[] args) {
        String[] a = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(solution(2, a)));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));
        for (int i = 0; i < words.length; i++) {
            if(i == 0 && words[i].length() == 1){
                answer = new int[]{1, 1};
                break;
            }
            if(i != 0 &&
                    (words[i].length() == 1 ||
                            words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0) || i != wordsList.indexOf(words[i]))){
                answer = new int[]{(i + 1) % n == 0 ? n : (i + 1) % n, (i+1) % n == 0 ? (i+1) / n : (i+1) / n + 1 };
                break;
            }
        }
        return answer;
    }

}
