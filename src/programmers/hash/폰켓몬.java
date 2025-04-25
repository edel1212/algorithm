package programmers.hash;

import java.util.HashMap;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        폰켓몬 obj = new 폰켓몬();
        System.out.println(obj.solution(nums));
    }

    public int solution(int[] nums) {
        int answer;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            // 값이 있을 경우 +1
            map.put(i, map.getOrDefault(i,0) + 1);
        } // loop

        int size = nums.length / 2;

        answer = map.size() >= size ?  size : map.size();

        return answer;
    }
}

