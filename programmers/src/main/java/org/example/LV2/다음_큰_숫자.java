package org.example.LV2;

public class 다음_큰_숫자 {
    /*
    * 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
    * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
    * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
    * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
    * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
    * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
    * 제한 사항
    * n은 1,000,000 이하의 자연수 입니다.
    * */
    public static void main(String[] args) {
        System.out.println(solution2(15));
    }
    /*
    * 풀이 방식
    * 1. 정수를 이진수 String 형태로 변환하고 '1'의 갯수를 구한다.
    * 2. 정수를 1씩 더하면서 이진수 String 형태로 변환하여 '1'의 갯수가 같은 정수를 그한다.
    * */
    public static int solution(int n){
        int answer = 0;
        int count = 0;
        String bin = Integer.toBinaryString(n);
        for(int i = 0; i < bin.length(); i++){
            if(bin.charAt(i) == '1'){
                count++;
            }
        }
        while(true){
            int count2 = 0;
            String bin2 = Integer.toBinaryString(++n);
            for(int i = 0; i < bin2.length(); i++){
                if(bin2.charAt(i) == '1'){
                    count2++;
                }
            }
            if(count2 == count){
                answer = n;
                break;
            }else{
                count2 = 0;
            }
        }
        return answer;
    }

    /*
    * 풀이 방식
    * Integer.bitcount 사용 => 이진수의 1인 갯수를 구함
    * */
    public static int solution2(int n){
        int answer = n + 1;
        int count = Integer.bitCount(n);
        while(true){
            if(count == Integer.bitCount(answer)) break;
            answer++;
        }
        return answer;
    }
}
