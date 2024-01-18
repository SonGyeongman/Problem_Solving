package org.example.LV1;

public class 신규_아이디_추천 {
    public static void main(String[] args) {
        /*
        * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        * 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        * 97 -> 122 48 -> 57 45,46,95
        * */
        String new_id = "abcdefghijklmn. p";
        System.out.println(processNewId(new_id));
    }

    public static String solution(String new_id){
        String answer = "";
        new_id = new_id.toLowerCase();
        for(int i = 0; i < new_id.length(); i++){
            int code = (int)new_id.charAt(i);
            if(code >= 97 && code <= 122 ||
                    code >= 48 && code <= 57 ||
                    code >= 45 && code <= 46 ||
                    code == 95){
                answer += new_id.charAt(i);
            }
            if(answer.length() > 1 &&
                    new_id.charAt(i) == '.' &&
                    new_id.charAt(i - 1) == '.'){
                answer = answer.substring(0, answer.length() - 1);
            }
            if(!answer.isEmpty() && answer.charAt(0) == '.'){
                answer = answer.substring(0, answer.length() - 1);
            }
            if(i == new_id.length() - 1 && new_id.charAt(i) == '.' ||
                    answer.length() == 15 && new_id.charAt(i) == '.'){
                answer = answer.substring(0, answer.length() - 1);
            }

            if(answer.length() == 15){
                break;
            }
            System.out.println(answer);
        }
        if(!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.'){
            answer = answer.substring(0, answer.length() - 1);
        }
        if(answer.equals("")){
            answer = "a";
        }
        if(answer.length() <= 2){
            while(answer.length() < 3){
                answer += answer.charAt(answer.length() - 1);
            }
        }
        return answer;
    }

    public static String processNewId(String newId) {
        // 1단계
        String step1 = newId.toLowerCase();

        // 2단계
        String step2 = step1.replaceAll("[^a-z0-9-_.]", "");

        // 3단계
        String step3 = step2.replaceAll("\\.{2,}", ".");

        // 4단계
        String step4 = step3.replaceAll("^\\.|\\.$", "");

        // 5단계
        String step5 = (step4.isEmpty()) ? "a" : step4;

        // 6단계
        String step6 = (step5.length() >= 16) ? step5.substring(0, 15) : step5;
        step6 = step6.replaceAll("\\.$", "");

        // 7단계
        String step7 = step6;
        while (step7.length() < 3) {
            step7 += step6.charAt(step6.length() - 1);
        }

        return step7;
    }
}
