package programmers.hash.revenge;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 의상_R2 {

    public static void main(String[] args){
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        new 의상_R2().solution(clothes);
    }

    public int solution(String[][] clothes) {
        int answer;

        Map<String, Long> map = Arrays.stream(clothes)
                .collect(Collectors.groupingBy( n-> n[1] , Collectors.counting()));

        answer = map.keySet().stream()
                .map(key -> map.get(key) + 1 )
                .mapToInt(i -> i.intValue())
                .reduce(1, (k,j) -> k*j);

        return answer - 1;
    }
}
