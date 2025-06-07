package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭_R6 {

    public static void main(String[] args){
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = { 7,4,5,6 };
        System.out.println(new 다리를_지나는_트럭_R6().solution(bridge_length, weight, truck_weights));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> vBridge = new LinkedList<>();
        // 가상의 다리 추가
        for(int i = 0 ; i < bridge_length - 1 ; i++) vBridge.offer(0);
        vBridge.offer(truck_weights[0]);
        int currentBridgeWeight = truck_weights[0];
        int truckIndex = 1;

        int answer = 0;
        while(!vBridge.isEmpty()){
            // 트럭 이동
            int move = vBridge.poll();
            answer++;
            currentBridgeWeight -= move;

            if(truckIndex < truck_weights.length ){
                int nextTruck = truck_weights[truckIndex];
                if(currentBridgeWeight + nextTruck <= weight){
                    currentBridgeWeight += nextTruck;
                    vBridge.offer(nextTruck);
                    truckIndex++;
                } else{
                    vBridge.offer(0);
                } // if -else
            } //if

        } // while

        return answer;
    }
}
