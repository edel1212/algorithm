package programmers.hash.revenge;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 폰캣몬_R2 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9};
        new 폰캣몬_R2().solution(nums);
    }

    public int solution(int[] nums) {
        int answer = nums.length / 2;

        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        int pocketMonType = map.keySet().size();
        if( answer > pocketMonType){
            return pocketMonType;
        }

        return answer;
    }
}
