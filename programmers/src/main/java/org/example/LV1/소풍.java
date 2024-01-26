package org.example.LV1;

public class 소풍 {
    public static void main(String[] args) {
        /*
        * 문제
        * 서로 친한사이끼리만 2명 쌍을 이루워서 짝을 짓는 문제
        * 1. 2명의 짝을 만들어준다.
        * 2. 2명이 true일 때만 만들어준다.
        * */
        int student = 4;
        int[] bestFriend = {0, 1, 1, 2, 2, 3, 3, 0, 0, 2, 1, 3};
        System.out.println(solution(student, bestFriend));
    }

    public static int solution(int student, int[] bestFriend){
        int answer = 0;
        boolean[][] check = new boolean[student][student];
        for(int i = 0; i < bestFriend.length; i += 2){
            check[bestFriend[i]][bestFriend[i + 1]] = true;
            check[bestFriend[i+1]][bestFriend[i]] = true;
        }
        for(boolean[] b : check){
            for(boolean c : b){
                if(c){
                    System.out.print("X ");
                }else{
                    System.out.print("O ");
                }
            }
            System.out.println(" ");
        }
        answer = dfs2(check, new boolean[student]);
        return answer;
    }

    public static int dfs(boolean[][] check, boolean[] taken){
        //문제점 중복을 제거 못함
        boolean finished = true;
        for(int i = 0; i < taken.length; i++) if(!taken[i]) finished = false;
        if(finished) return 1;
        int step = 0;
        for(int i = 0; i < check.length; i++){
            for(int j = 0; j < check[i].length; j++){
                if(!taken[i] && !taken[j] && check[i][j]){
                    taken[i] = taken[j] = true;
                    step += dfs(check, taken);
                    taken[i] = taken[j] = false;
                    System.out.println(i + " " + j);
                }
            }
        }
        return step;
    }

    public static int dfs2(boolean[][] check, boolean[] taken){
        int firstFree = -1;
        for(int i = 0; i < taken.length; i++){
            if(!taken[i]){
                firstFree = i;
                break;
            }
        }
        if(firstFree == -1) return 1;
        int ret = 0;
        for(int i = firstFree+1; i < check.length; i++){
            if(!taken[i] && check[firstFree][i]){
                taken[firstFree] = taken[i] = true;
                ret += dfs2(check, taken);
                taken[firstFree] = taken[i] = false;
                System.out.println(firstFree + " " + i);
            }
        }
        return ret;
    }
}
