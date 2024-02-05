package org.example.baekjoon.gold;

public class 트리 {

    static int[] pre = {3,6,5,4,8,7,1,2};
    static int[] in = {5,6,8,4,3,1,2,7};
    public static void main(String[] args) {
        // 3,6,5,4,8,7,1,2 전위 5,6,8,4,3,1,2,7 중위

        int start = 0;
        int end = in.length;

        for(int i = 0; i < pre.length; i++){
            int root = pre[i];

            for (int j = start; j < end; j++) {
                if(root == in[j]){

                }
            }
        }

    }

    public static void postorder(int root, int start, int end){

    }

    public static int find(int root){
        int answer = 0;
        return answer;
    }
}
