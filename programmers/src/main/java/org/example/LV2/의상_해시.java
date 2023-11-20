package org.example.LV2;

import java.nio.file.attribute.AclFileAttributeView;
import java.util.HashMap;

public class 의상_해시 {
    public static void main(String[] args) {
        String[][] arr = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(arr));
    }
    /*
    * 조합 경우의 수 구하기
    * 총 경우의 수 = (a + 1) * (b + 1) * (c + 1) - 1
    * +1을 하는 경우는 선택하지 않았을 경우를 포함하기 위해서고, -1은 전체를 선택하지 않았다는 경우의 수를 제거하기 위해서이다.
    * */
    public static int solution(String[][] clothes){
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(Integer i : map.values()){
            answer *= i.intValue() + 1;
        }

        return answer - 1;
    }
}
