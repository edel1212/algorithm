package programmers.brute_force.revenage;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기_R2 {
    Set<Integer> numSet = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        for (int num : numSet) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }

    // 일단 모든 경우의 수를 만들어야함
    private void makeNumber(String addNum, String remainderNum){
        if(!addNum.isEmpty()) numSet.add(Integer.valueOf(addNum));

        // 재귀 종료 조건 문자열 다소모
        for(int i = 0 ; i < remainderNum.length(); i ++){
            String makeAddNum = addNum + remainderNum.charAt(i);
            String makeRemainderNum = remainderNum.substring(0,i)
                    + remainderNum.substring(i + 1);
            makeNumber(makeAddNum, makeRemainderNum);
        } // for
    }

    private boolean isPrime(int num){
        if( num < 2 ) return false;
        int sqrt = (int) Math.sqrt(num);
        for(int i = 2 ; i <= sqrt ; i++){
            if( num % i == 0 ) return false;
        } //for
        return true;
    }

}
