package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭_R7 {

    public static void main(String[] args) {
        new 다리를_지나는_트럭_R7().solution(2,10, new int[]{7,5,4,6});
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0 ; i < bridge_length - 1 ; i++) bridge.offer(0);
        bridge.offer(truck_weights[0]);
        int currentBridgeWeight = truck_weights[0];
        int time = 1;
        int truckIdx = 1;

        while( !bridge.isEmpty() ){
            time++;
            int move = bridge.poll();
            currentBridgeWeight -= move;

            // 트럭이 더 올라 갈 수 있는지 확인 - 반복분이 아닌 이유는 다리의 길이가 정해져 있기 때문임
            if(truckIdx < truck_weights.length ){
                if(currentBridgeWeight + truck_weights[truckIdx] <= weight){
                    bridge.offer(truck_weights[truckIdx]);
                    currentBridgeWeight += truck_weights[truckIdx];
                    truckIdx++;
                }  else {
                    bridge.offer(0);
                } // if - else
            } // if

        } // while

        return time;
    }
}
