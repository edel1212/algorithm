package programmers.heap.revenge;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 이중우선큐_R2 {
    // goal : 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때,
    //        모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.;
    //        - I 숫자	큐에 주어진 숫자를 삽입합니다.
    //        - D 1	큐에서 최댓값을 삭제합니다.
    //        - D -1	큐에서 최솟값을 삭제합니다.
    // condition : 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
    //            - 원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
    public static void main(String[] args){
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        new 이중우선큐_R2().solution(operations);
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for(String s : operations){

            if(s.startsWith("I ")){
                int num = Integer.valueOf(s.replace("I ",""));
                maxHeap.offer(num);
                minHeap.offer(num);
                countMap.put(num, countMap.getOrDefault(num,0) + 1);
            } else if("D 1".equals(s)){
                refreshMap(maxHeap, countMap);
            } else if("D -1".equals(s)){
                refreshMap(minHeap, countMap);
            } else {
                throw new RuntimeException("unknown keyword");
            } // if - else

        }//

        int[] answer = new int[2];
        answer[0] = getValue(maxHeap, countMap);
        answer[1] = getValue(minHeap, countMap);

        return answer;
    }

    protected void refreshMap(PriorityQueue<Integer> heap, Map<Integer, Integer> map){
        while(!heap.isEmpty()){
            int num = heap.poll();
            if(map.containsKey(num)){
              map.put(num, map.get(num) - 1 );
              if(map.get(num) < 1) map.remove(num);
              break;
            } // if
        }// while
    }

    protected int getValue(PriorityQueue<Integer> heap, Map<Integer, Integer> map){
        while (!heap.isEmpty()){
            int num = heap.poll();
            if(map.containsKey(num)) return num;
        } // while
        return 0;
    }
}
