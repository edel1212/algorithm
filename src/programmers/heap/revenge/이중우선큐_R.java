package programmers.heap.revenge;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 이중우선큐_R {
    // goal : 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때,
    //        모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.;
    //        - I 숫자	큐에 주어진 숫자를 삽입합니다.
    //        - D 1	큐에서 최댓값을 삭제합니다.
    //        - D -1	큐에서 최솟값을 삭제합니다.
    // condition : 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
    //            - 원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
    public static void main(String[] args){
        //String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        new 이중우선큐_R().solution(operations);
    }

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();

        for(String str : operations){

            if(str.startsWith("I")){
                Integer parseStr = Integer.parseInt(str.replace("I ",""));
                minHeap.offer(parseStr);
                maxHeap.offer(parseStr);
                map.put("min", minHeap);
                map.put("max", maxHeap);
            } else if("D -1".equals(str)){ // 최소값 삭제
                remove(map, minHeap);
            } else if("D 1".equals(str)){ // 최대값 삭제
                remove(map, maxHeap);
            } else{
                throw new RuntimeException("잘못들어온 값 입니다.");
            } // if else
        } // for

        answer[0] = maxHeap.isEmpty() ? 0 : maxHeap.poll();
        answer[1] = minHeap.isEmpty() ? 0 : minHeap.poll();

        return answer;
    }

    public void remove(Map<String, PriorityQueue<Integer>> map , PriorityQueue<Integer> heap){
        if(heap.isEmpty()) return;
        int removeTarget = heap.poll();
        map.keySet().forEach(key->{
            map.get(key).remove(removeTarget);
        });
    }

    /** -------------------------------------------------------- */
    public int[] solution2(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> minPriority = new PriorityQueue<>();
        PriorityQueue<Integer> maxPriority = new PriorityQueue<>(Comparator.reverseOrder());
        // 값의 개수를 동기화 하기 위한 Map - 내가 사용한건 두개의 priority를 map에 저저장하여 사용했었음
        Map<Integer, Integer> countMap = new HashMap<>();

        for(String s : operations){
            if(s.startsWith("I")){ // 추가
                int num = Integer.valueOf(s.replace("I ",""));
                minPriority.offer(num);
                maxPriority.offer(num);
                // 들어온 숫자를 카운팅함 개수 확인
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            } else if("D 1".equals(s)){ // 최대값 삭제
                reFreshMapCount(maxPriority, countMap);
            } else { // 최소값 삭제
                reFreshMapCount(minPriority, countMap);
            } // if - else
        } // for

        int max = getResult(maxPriority, countMap);
        int min = getResult(minPriority, countMap);

        return countMap.isEmpty() ? new int[]{0, 0} : new int[]{max, min};
    }

    private void reFreshMapCount(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap){
        while(!heap.isEmpty()){
            int targetNum = heap.poll();
            if(countMap.containsKey(targetNum)){
                // count Map 에서 제거
                countMap.put(targetNum, countMap.getOrDefault(targetNum, 0) - 1);

                if(countMap.get(targetNum) < 1) countMap.remove(targetNum);
                break;
            } //
        } // while
    }

    private int getResult(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap){
        while (!heap.isEmpty()){
            int target = heap.peek();
            if(countMap.containsKey(target)){
                return target;
            } else {
                heap.poll();
            } // if - else
        }// while
        return 0;
    }
}
