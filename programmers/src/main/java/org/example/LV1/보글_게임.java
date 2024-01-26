package org.example.LV1;

public class 보글_게임 {

    static final int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
    static final int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};
    public static void main(String[] args) {
        /*문제 주어진 단어 ex) "PRETTY" 가 아래의 보드판에 상하좌우 대각선 중복 상관없 단어를 만들 수 있으면 "YES"를 만들 수 없으면 "NO"를
        반환하는 문제 */
        /*
        * 풀이 방식
        * 1. 주어진 단어의 첫번째 단어가 있는 곳을 찾는다.
        * 2. 재귀함수를 통해 상하좌우 대각선 모든 알파벳을 검사하여 이어지는 알파벳을 찾는다.
        * 3. 마지작 알파벳까지 찾으면 true 끝이나면 false를 반환한다.
        *
        * 회고
        * 상하좌우 대각선에 다음 알파벳이 일치하면 계속해서 다음 재귀를 호출하여 이어 나간다.
        *
        * */
        char[][] alpha = {
                {'U', 'R', 'L', 'P', 'M'},
                {'X', 'P', 'R', 'E', 'T'},
                {'G', 'I', 'A', 'E', 'T'},
                {'X', 'T', 'N', 'Z', 'Y'},
                {'X', 'O', 'Q', 'R', 'S'}};
        System.out.println(solution(alpha, "PRETTY"));
    }

    public static String solution(char[][] alpha, String word){
        String answer = "NO";
        for(int i = 0; i < alpha.length; i++){
            for(int j = 0; j < alpha[i].length; j++){
                if(dfs(alpha, word, j, i)){
                    answer = "YES";
                    break;
                }
            }
        }
        return answer;
    }

    public static boolean dfs(char[][] alpha, String word, int x, int y){
        if(!((x >= 0 && x < alpha[0].length) && (y >= 0 && y < alpha.length))) return false;
        if(alpha[y][x] != word.charAt(0)) return false;
        if(word.length() == 1) return true;
        for(int i = 0; i < 8; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(dfs(alpha, word.substring(1), nextX, nextY)){
                return true;
            }
        }
        return false;
    }

    
}
