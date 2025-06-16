package programmers.brute_force.revenage;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기_R5 {

    public static void main(String[] args) {
        System.out.println(new 소수찾기_R5().solution("17"));
    }
    Set<Integer> nums = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        makeNum("",numbers);
        for(int item : nums){
            if( permitted(item) ) answer++;
        } // for
        return answer;
    }

    public boolean permitted(int num){
        if( num < 2 ) return false;
        int sqrt = (int) Math.sqrt(num);
        for(int i = 2 ; i <= sqrt ; i++){
            if( num % i == 0 ) return false;
        } // for
        return true;
    }

    public void makeNum(String addNum, String remainderNum){
        if(!addNum.isEmpty()) nums.add(Integer.parseInt(addNum));
        for(int i = 0 ; i < remainderNum.length(); i ++){
            String makeAddNum = addNum + remainderNum.charAt(i);
            String makeRemainderNum = remainderNum.substring(i + 1) + remainderNum.substring(0, i);
            makeNum(makeAddNum, makeRemainderNum);
        } // for
    }
}
