package programmers.hash;

import java.util.*;
import java.util.stream.Collectors;

public class 의상 {
    // 목적 : 2차원 배열이 주어질때 각 배열의 1개씩을 조합하여 의상을 만듬 한개씩은 겹치지 않으면 count 인정 - 한개만 입어도 ㄱㅊ
    // 전제 조건 : - clothes의 각 행은 [ "의상 이름", 종류 ], 로 구성 되어있음
    //           - 의상의 개수는 1개 이상 30새 이하
    //           - 같은 이름의 의상은 존재하지 않음
    //           - 문자열의 길이는 1이상 20이하 자연수 이며, 알파멧 소문자 또는 '_'로만 이뤄져있음
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        의상 obj = new 의상();
        System.out.println(obj.solution(clothes));
    }

    public int solution(String[][] clothes) {
        // 곱셈을 진행하기 위해 1로 선언
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for(String[] item : clothes){
            String clothesType = item[1];
            // 의상의 종류별로 개수를 구함
            map.put(clothesType, map.getOrDefault(clothesType, 0) + 1);
        }// loop

        // 아무것도 입지 않을 경우를 위해 item에 1을 추가해줌
        for(int item : map.values()) answer *= (item + 1);

        // 모두 아무것도 안 입을 경우의 수 인 1을 빼줌
        return answer - 1;
    }

    public int solution2(String[][] clothes) {

        return Arrays.asList(clothes).stream()
                // Map 변환
                .collect(Collectors.groupingBy( k -> k[1]
                        , Collectors.mapping( p -> p[0], Collectors.counting() ) ))
                .values()
                .stream()
                .reduce(1L, (i, j) -> i * (j + 1))
                .intValue() - 1;
    }
}



    //얼굴	동그란 안경, 검정 선글라스
    //상의	파란색 티셔츠, 핑크 셔츠
    //하의	청바지
    //겉옷	긴 코트, 숏 코트