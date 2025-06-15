package programmers.hash.revenge;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 의상_R3 {
    public int solution(String[][] clothes) {
        Map<String, Long> map = Arrays.stream(clothes)
                .collect(Collectors.groupingBy( k -> k[1], Collectors.counting() ));
        int answer = 1;

        for(String key : map.keySet()){
            answer *= map.get(key) + 1;
        } // for

        return answer - 1;
    }
}
