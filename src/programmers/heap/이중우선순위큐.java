package programmers.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    // goal : 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때,
    //        모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.;
    //        - I 숫자	큐에 주어진 숫자를 삽입합니다.
    //        - D 1	큐에서 최댓값을 삭제합니다.
    //        - D -1	큐에서 최솟값을 삭제합니다.
    public static void main(String[] args){
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        new 이중우선순위큐().solution(operations);
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPriority = new PriorityQueue<>();
        PriorityQueue<Integer> maxPriority = new PriorityQueue<>(Comparator.reverseOrder());
        // 값의 개수를 동기화 하기 위한 Map
        Map<Integer, Integer> countMap = new HashMap<>();

        for(String s : operations){
            if(s.startsWith("I")){ // 추가
                int num = Integer.valueOf(s.replace("I ",""));
                minPriority.offer(num);
                maxPriority.offer(num);
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            } else if("D 1".equals(s)){ // 최대값 삭제
                remove(maxPriority, countMap);
            } else { // 최소값 삭제
                remove(minPriority, countMap);
            } // if - else
        } // for

        int max = getValid(maxPriority, countMap);
        int min = getValid(minPriority, countMap);

        return countMap.isEmpty() ? new int[]{0, 0} : new int[]{max, min};
    }

    private void remove(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap){
        while(!heap.isEmpty()){
            // 우선 순위 큐의 값 추출
            int num = heap.poll();
            if(countMap.containsKey(num)){ // 값이 있을 경우
                // countMap에서 해당 개수 제거
                countMap.put(num, countMap.get(num) - 1);
                // map에 count가 다 됐을 경우 countMap에세 제거
                if (countMap.get(num) == 0) countMap.remove(num);
                break;
            } // if
        }// while
    }

    private int getValid(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap){
        while(!heap.isEmpty()){
            // 일단 비교가 먼저면 불필요하게 poll 부터 할필요가 앖음
            int num = heap.peek();
            if( countMap.containsKey(num) ){
                return num;
            } else{
                //  “버그 방지 + 효율적 설계”를 위한 코딩 습관
                heap.poll();
            } // if - else
        } // for
        return 0;
    }

}
