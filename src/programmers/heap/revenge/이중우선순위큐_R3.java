package programmers.heap.revenge;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 이중우선순위큐_R3 {
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

    protected int getValue(PriorityQueue<Integer> heap, Map<Integer, Integer> map){
        while (!heap.isEmpty()){
            int num = heap.poll();
            if(map.containsKey(num)) return num;
        } // while
        return 0;
    }

    public void refreshMap(PriorityQueue<Integer> heap , Map<Integer, Integer> countMap){
        while(!heap.isEmpty()){
            int removeTarget = heap.poll();
            if(countMap.containsKey(removeTarget)){
                countMap.put(removeTarget, countMap.get(removeTarget) - 1);
                if(countMap.get(removeTarget) < 1) countMap.remove(removeTarget);
                break;
            }// if
        } //if
    }
}
