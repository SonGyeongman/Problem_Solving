package org.example.LV1;

public class 키패드_누르기 {
    public static void main(String[] args) {
        //147 왼 369 오 2580 가까운 순
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand){
        String answer = "";
        char left = '*';
        char right = '#';
        for(int i : numbers){
            if(i == 1 || i == 4 || i == 7){
                answer += 'L';
                left = (char) i;
            }else if(i == 3 || i == 6 || i == 9){
                answer += 'R';
                right = (char) i;
            }
        }
        return answer;
    }

    public static int dic(char num, char hand){
        int result = 0;
        char[][] position ={{'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'}};
        
        return result;
    }
}
