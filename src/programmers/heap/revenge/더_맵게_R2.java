package programmers.heap.revenge;

import java.util.PriorityQueue;

public class 더_맵게_R2 {


    public static void main(String[] args){
        System.out.println(new 더_맵게_R2().solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int item : scoville) heap.offer(item);

        int answer = 0;
        while( 2 <= heap.size() && heap.peek() < K ){
            answer++;
            int min = heap.poll();
            int nextMin = heap.poll();
            heap.offer( min + ( nextMin * 2 ) );
        } // while

        if( !heap.isEmpty() && heap.peek() < K  ) return  -1;

        return answer;
    }

}
