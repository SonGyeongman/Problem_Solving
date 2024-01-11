package org.example.LV2;

public class PCCP_석유시추 {
    public static void main(String[] args) {

    }

    public static int solution(int[][] land){
        /*
        * [
        * [0, 0, 0, 1, 1, 1, 0, 0],
        * [0, 0, 0, 0, 1, 1, 0, 0],
        * [1, 1, 0, 0, 0, 1, 1, 0],
        * [1, 1, 1, 0, 0, 0, 0, 0],
        * [1, 1, 1, 0, 0, 0, 1, 1]
        * ]
        * */
        int answer = 0;
        int count = 0;
        int step = 0;
        for(int i = 0; i < land[0].length; i++){
            for(int j = 0; j < land.length; j++){
                while(true){
                    if(land[j][i + step] == 1) {
                        count++;
                        step++;
                    }else{

                    }
                }
            }
        }
        return answer;
    }
}
