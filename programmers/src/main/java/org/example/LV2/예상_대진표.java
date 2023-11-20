package org.example.LV2;
public class 예상_대진표 {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
        System.out.println(Integer.toBinaryString(3^6));
    }

    public static int solution(int n, int a, int b){
        int answer = 1;
        while(n >= 2){
            int[] t = new int[n];
            t[a-1] = 1;
            t[b-1] = 1;
            for (int i = 0; i < n; i += 2) {
                if(t[i] == 1 && t[i+1] == 1){
                    return answer;
                }
            }
            n = n/2;
            a = a/2 + a%2;
            b = b/2 + b%2;
            answer++;
        }
        return answer;
    }

    public static int solution2(int n, int a, int b){
        int answer = 0;
        while(a != b){
            a = a/2 + a%2;
            b = b/2 + b%2;
            answer++;
        }
        return answer;
    }

    public static int solution3(int n, int a, int b){
        return Integer.toBinaryString((a-1) ^ (b-1)).length();
    }
}
