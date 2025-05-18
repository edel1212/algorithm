package programmers.sort;

import java.util.*;
import java.util.stream.Collectors;

public class HIndex {
    // goal : 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index
    public static void main(String[] args){
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(new HIndex().solution(citations));
    }

    // 전체 정렬 내림 차순 정렬
    // 총 개수를 구함
    // 총 개수 별 카운트를 구해서 내림 차순 정렬 후 딱딱
    public int solution(int[] citations) {
        int answer = 0;

        // 오름 차순 정렬 - 작은 인용수부터 차례로 보면서, 그 인용 수보다 큰 수가 몇 개 남아 있는지(h) 판단
        Arrays.sort(citations);
        // 논문의 개수
        int citationsCnt = citations.length;

        for(int idx = 0 ; idx < citationsCnt ; idx++){
            // 전체 논문 개수 - index ( 가장 큰수가 나옴 )
            int h = citationsCnt - idx;
            // 논문의 개수와 h-index를 비교해서 적합 판정일 경우 반환
            if (citations[idx] >= h) return h;
        } // for

        return answer;
    }


    public int solution2(int[] citations) {
        int answer = 0;

        // 논문의 인용 횟수 오름 차순 정렬
        Arrays.sort(citations);

        int citCnt = citations.length;
        for(int i = 0 ; i < citCnt ; i++){
            // 총 발표 논문 - 인용 횟수
            int h = citCnt - i;
            if(citations[i] >= h) return h;

        } // for

        return answer;
    }
}
