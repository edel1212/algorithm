package programmers.heap.revenge;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 이중우선큐_R3 {

    public static void main(String[] args) {
        new 이중우선큐_R3().solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer>  minHeap = new PriorityQueue<>();
        PriorityQueue<Integer>  maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
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
        } // for

        int[] answer = new int[2];
        answer[0] = getValue(maxHeap, countMap);
        answer[1] = getValue(minHeap, countMap);
        return answer;
    }

    public void refreshMap(PriorityQueue<Integer> heap, Map<Integer,Integer> map){
        while(!heap.isEmpty()){
            int current = heap.poll();
            if(map.containsKey(current)){
                map.put(current, map.get(current) - 1);
                if(map.get(current) < 1) map.remove(current);
                break;
            } // if
        } // while
    }

    public int getValue(PriorityQueue<Integer> heap, Map<Integer,Integer> map){
        while(!heap.isEmpty()){
            int item = heap.poll();
            if( map.containsKey(item) ) return item;
        }
        return 0;
    }

}
