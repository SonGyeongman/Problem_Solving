package org.example.Algorithm;

public class 깊이우선탐색 {
    public static void main(String[] args) {
        String[] words = {"gg", "kia", "lotte", "lg", "hanwha"};
        int[][] count = makeGraph(words);
        for(int[] a : count){
            System.out.println("");
            for(int b : a){
                System.out.print(b + " ");
            }
        }
    }

    public static int[][] makeGraph(String[] words){
        int[][] count = new int[26][26];
        for(int i = 1 ; i < words.length; i++){
            int j = i -1;
            int len = Math.min(words[j].length(), words[i].length());
            for(int k = 0; k < len; k++){
                if(words[j].charAt(k) != words[i].charAt(k)){
                    int a = words[j].charAt(k) - 'a';
                    int b = words[i].charAt(k) - 'a';
                    count[a][b] = 1;
                    break;
                }
            }
        }
        return count;
    }

    public static int dfs(){
        int answer = 0;
        return answer;
    }
}
