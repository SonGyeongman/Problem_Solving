package org.example.LV2;

public class 피보나치 {
    /**
     * 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
     *
     * 예를들어
     *
     * F(2) = F(0) + F(1) = 0 + 1 = 1
     * F(3) = F(1) + F(2) = 1 + 1 = 2
     * F(4) = F(2) + F(3) = 1 + 2 = 3
     * F(5) = F(3) + F(4) = 2 + 3 = 5
     */
    public static void main(String[] args) {
        System.out.println(fibo2(3));
    }
    // 재귀 함수 풀이 방식
    public static int fibo(int n){
        if(n <= 1)
            return n;
        else
            return fibo(n-2) + fibo(n-1);
    }
    // 배열 풀이 방식
    // 자료형의 크기에 제한 있는 언어를 쓸 경우 (A + B) % C = ((A % C) + (B % C)) % C 라는 성질을 이용해서
    // 매번 계산 결과에 1234567으로 나눈 나머지를 대신 넣어 int 범위 내에 항상 값이 존재함을 보장한다.
    public static int fibo2(int n){
        int[] answer = new int[n + 1];

        for(int i = 0; i <= n; i++){
            if (i == 0) answer[i] = 0;
            else if (i == 1) answer[i] = 1;
            else{
                int sum = answer[i - 2] + answer[i - 1];
                answer[i] = sum % 1234567;
            }
        }
        return answer[n];
    }
}
