package programmers.brute_force.revenage;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기_R3 {

    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        makeNum("", numbers);
        for(int item : set){
            if(isPrime(item)) answer++;
        }
        return answer;
    }

    public void makeNum(String addNum, String remainderNum){
        if(addNum != null) set.add(Integer.parseInt(addNum));
        for(int i = 0 ; i < remainderNum.length(); i++){
            String makeAddNum = addNum + remainderNum.charAt(i);
            String makeRemainderNum = remainderNum.substring(0,i) + remainderNum.substring(i+1);
            makeNum(makeAddNum, makeRemainderNum);
        } // for
    }

    private boolean isPrime(int num){
        // 소수는 0과 1은 제외임
        if( num < 2 ) return false;
        // 합성수는 반드시 자기보다 작은 두 수의 곱으로 표현할 수 있가애 범위를 좁히기 위함
        int sqrt = (int) Math.sqrt(num);
        // 2부터 시작하는 이유: 모든 수는 1로 나눠지므로 의미 없기 때문임
        for(int i = 2 ; i <= sqrt ; i++){
            // 나눠 떨어지면 소수가 아님
            if( num % i == 0 ) return false;
        } //for
        return true;
    }

}
