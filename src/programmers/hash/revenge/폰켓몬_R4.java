package programmers.hash.revenge;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class 폰켓몬_R4 {
    public int solution(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int answer = nums.length / 2;
        return answer < set.size() ? answer :  set.size();
    }
}
