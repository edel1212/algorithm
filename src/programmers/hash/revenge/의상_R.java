package programmers.hash.revenge;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 의상_R {
    // 목적 : 코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다. 예를 들어 위 예시의 경우 동그란 안경과 검정 선글라스를 동시에 착용할 수는 없습니다.
    //      - 착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산
    //      - 코니는 하루에 최소 한 개의 의상은 입습니다.

    // 제한 사항 : clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다
    //          - 코니가 가진 의상의 수는 1개 이상 30개 이하입니다.
    //          - 같은 이름을 가진 의상은 존재하지 않습니다.
    public static void main(String[] args){
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        의상_R obj = new 의상_R();
        System.out.println(obj.solution(clothes));
    }

    public int solution(String[][] clothes){
        Map<String, Long> map = Arrays.asList(clothes).stream()
                .collect(Collectors.groupingBy( n -> n[1], Collectors.counting() ));

        int answer = map.values().stream().mapToInt(o -> o.intValue())
                .map(i -> i + 1)
                .reduce(1, (a, b) -> a * b);

        // 아무것도 입지 않을 경우 제외
        return answer - 1;
    }
}
