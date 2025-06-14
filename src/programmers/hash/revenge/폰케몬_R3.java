package programmers.hash.revenge;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class 폰케몬_R3 {
    public int solution(int[] nums) {
        int maxNum = nums.length / 2;

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int typeFilter = set.size();

        return Math.min(typeFilter, maxNum);
    }
}
