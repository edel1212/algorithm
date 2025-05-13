package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭_R3 {
    public static void main(String[] args){
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = { 7,4,5,6 };
        System.out.println(new 다리를_지나는_트럭_R3().solution(bridge_length, weight, truck_weights));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights){

        Queue<Integer> vBridge = new LinkedList<>();
        // 가상 다리
        for(int i = 0 ; i < bridge_length - 1 ; i++) vBridge.offer(0);
        int currentBridgeWeight = truck_weights[0];
        vBridge.offer(currentBridgeWeight);
        int time = 1;
        int index = 1;

        while (!vBridge.isEmpty()){
            time++;
            int moveTruck = vBridge.poll();
            currentBridgeWeight -= moveTruck;

            if( index < truck_weights.length ){

                int newTruck = truck_weights[index];

                if(newTruck + currentBridgeWeight <= weight){
                    // 현재 다리에 신규 트럭 입장으로 무게 추가
                    currentBridgeWeight += truck_weights[index];
                    // 가상의 다리에 현자 트럭 추가
                    vBridge.offer(truck_weights[index]);
                    // 순번 추가
                    index++;
                } else {
                    vBridge.offer(0);
                } // if - elses

            } // if
        } // while

        return time;
    }
}
