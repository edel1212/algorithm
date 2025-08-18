package programmers.hash.revenge;

import java.util.HashMap;
import java.util.Map;

public class 의상_R4 {
    public int solution(String[][] clothes) {
        Map<String, Long> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String k = clothes[i][1];
            map.put(k, map.getOrDefault(k,0L) + 1);
        } // for

        // 안 입었을 경우가 있기에 각 종류별 + 1
        int answer = map.keySet().stream().map(k -> map.get(k) + 1)
                .reduce((a,b)->  a*b)
                .get().intValue();

        // 전부다 안 입었을 경우 제외
        return answer - 1;
    }
}
