package programmers.heap.revenge;

import java.util.PriorityQueue;
import java.util.Queue;

public class 더_맵게_R {
    // goal : 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
    // 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    // condition : scoville의 길이는 2 이상 1,000,000 이하입니다.
    //             K는 0 이상 1,000,000,000 이하입니다.
    //              scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
    //              모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
    public static void main(String[] args){
        //int[] scoville = {1, 2, 3, 9, 10, 12};
        int[] scoville = {1, 1};
        int k = 7;
        new 더_맵게_R().solution(scoville, k);
    }

    // 우선순위 heap으로 만듬 첫번째 값 비교 loop
    public int solution(int[] scoville, int k) {
        int answer = 0;

        Queue<Integer> heap = new PriorityQueue<>();
        for( int i : scoville ) heap.offer(i);

        while(!heap.isEmpty()){
            if(heap.size() == 1 && heap.peek() < k ) return - 1;
            int currentScoville = heap.poll();

            if( !heap.isEmpty() && currentScoville < k ){
                answer++;
                int mix = currentScoville + ( heap.poll() * 2 );
                heap.offer(mix);
            } // if

        } // while

        return answer;
    }

}
