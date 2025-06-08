package programmers.heap.revenge;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 이중우선순위큐_R4 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> countMap = new HashMap<>();
        for(String str : operations){
            if(str.startsWith("I ")){
                int num = Integer.parseInt(str.replace("I ", ""));
                minHeap.offer(num);
                maxHeap.offer(num);
                countMap.put(num, countMap.getOrDefault(countMap, 0) + 1);
            } else if("D 1".equals(str)){
                adjustHeap(maxHeap, countMap);
            } else if("D -1".equals(str)){
                adjustHeap(minHeap, countMap);
            } else {
                throw new RuntimeException("Error");
            }
        }// for

        int[] answer = new int[2];
        answer[0] = getValue(maxHeap,countMap);
        answer[1] = getValue(minHeap,countMap);
        return answer;
    }

    public int getValue(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap){
        while(!heap.isEmpty()){
            int current = heap.poll();
            if(countMap.containsKey(current)){
                countMap.put(current, countMap.get(current) - 1);
                return current;
            } // if
        } //while
        return 0;
    }

    public void adjustHeap(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap){
        while (!heap.isEmpty()){
            int current = heap.poll();
            if(countMap.containsKey(current)){
                countMap.put(current, countMap.get(current) - 1);
                if( countMap.get(current) <= 0 ){
                    countMap.remove(current);
                    break;
                }
            } // if
        } // while
    }
}
