package programmers.heap;

import java.util.PriorityQueue;

public class 더_맵게 {
    // goal : 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
    //       - 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    //       - 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
    //       - 진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return
    //
    // condition : - scoville의 길이는 2 이상 1,000,000 이하입니다.
    //             - K는 0 이상 1,000,000,000 이하입니다.
    //             - scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
    //             - 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다
    public static void main(String[] args){
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(new 더_맵게().solution(scoville, k));
    }

    // solution : 1. heap 생성
    //            2. while문을 통해 검사  조건 : k 미만의 스코비 지수가 있을 경우까지
    //            3. 있을 경우 answer++
    //            4. 스코비 지수가 0으로 나올 경우 -1로 마무리
    public int solution(int[] scoville, int k){
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(scoville.length);
        for(int item : scoville) priorityQueue.add(item);

        // 음식의 개수가 2개 이상과 가장 낮은 스코빌음식의 지수가 원하는 값보다 낮을 경우
        while ( 2 <= priorityQueue.size() && priorityQueue.peek() < k ){
            answer++;
            int minFood = priorityQueue.poll();
            int secondFood = priorityQueue.poll();
            int mix = minFood + ( secondFood * 2 );
            priorityQueue.add(mix);
        } //

        // 마지막 한 개 남은 음식이 K 이상인지 확인
        if (priorityQueue.peek() < k) return -1;

        return answer;
    }


}
