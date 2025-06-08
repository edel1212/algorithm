package programmers.brute_force.revenage;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기_R4 {
    public  static  void main(String[] args){
        System.out.println(new 소수찾기_R4().solution("17"));
    }
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        makeNum("", numbers);

        for(int num : set){
            if(prime(num)) answer++;
        }

        return answer;
    }

    public boolean prime(int num){
        if(num < 2) return  false;
        int sqrt = (int) Math.sqrt(num);
        for(int i = 2 ; i <= sqrt; i ++){
            if( num % i == 0) return  false;
        } // for
        return true;
    }

    public void makeNum(String addNum, String remainderNum){
        if(!addNum.isEmpty()) set.add(Integer.parseInt(addNum));

        for(int i = 0; i < remainderNum.length(); i ++){
            String makeAddNum = addNum + remainderNum.charAt(i);
            String makeRemainderNum = remainderNum.substring(0, i) + remainderNum.substring(i + 1);
            makeNum(makeAddNum, makeRemainderNum);
        } // for
    }
}
