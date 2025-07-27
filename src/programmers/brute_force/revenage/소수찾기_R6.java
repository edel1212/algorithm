package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.List;

public class 소수찾기_R6 {
    List<Integer> allNumbers = new ArrayList<>();

    public static void main(String[] args) {
        new 소수찾기_R6().solution("011");
    }

    public int solution(String numbers) {
        // 전달 받은 문자열로 모든 경우의 수의 숫자 배열을 만들어야함
        // 배열을 순회하며, 소수인지 반환

        dfs("", numbers);

        int answer = 0;
        for(Integer num : allNumbers){
            if(check(num)) answer++;
        } // for

        System.out.println(answer);
        return answer;
    }

    public boolean check(int num){
        // 0과 1은 소수가 아님
        if(num <= 1) return false;
        // 루트 값을 가져옴
        int sqrt = (int) Math.sqrt(num);
        // 소수 판별은 2부터 시작 ~ 루트 값 범위까지 - 탐색 범위 축소
        for(int i = 2 ; i <= sqrt; i++){
            // 나누어 떨어지면 소수가 아님
            if(num % i == 0) return false;
        } // for
        return true;
    }

    public void dfs(String addStr, String remainderStr){
        if(!addStr.isEmpty()) allNumbers.add(Integer.parseInt(addStr));
        for(int i = 0 ; i < remainderStr.length(); i++){
            String add = addStr + remainderStr.charAt(i);
            String re  = remainderStr.substring(i+1) + remainderStr.substring(0, i);
            dfs(add, re);
        } // for
    }
}
