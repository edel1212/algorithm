package programmers.hash.revenge;

import java.util.HashMap;
import java.util.Map;
public class 폰켓몬_R {

    // 총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다.
    //
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        폰켓몬_R obj = new 폰켓몬_R();
        System.out.println(obj.solution(nums));
    }

    public int solution(int[] nums) {
        int size = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i,0) + 1);

        return map.size() > size ? size : map.size();
    }
}
