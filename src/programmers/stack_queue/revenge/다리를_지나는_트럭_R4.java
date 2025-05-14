package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭_R4 {
    // goal : 다리를 지나는데 걸리는 시간
    public static void main(String[] args){
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = { 7,4,5,6 };
        System.out.println(new 다리를_지나는_트럭_R4().solution(bridge_length, weight, truck_weights));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights){
        Queue<Integer> vBridge = new LinkedList<>();
        for(int i = 0 ; i < bridge_length - 1 ; i++) vBridge.offer(0);
        int currentBridgeWeight = truck_weights[0];
        vBridge.offer(currentBridgeWeight);
        // 소요 시간
        int timeTaken = 1;
        // 트럭 위치 추적을 위함
        int index = 1;

        while(!vBridge.isEmpty()){
            timeTaken++;
            int moveTruck = vBridge.poll();
            currentBridgeWeight -= moveTruck;

            if(index < truck_weights.length){

                if( truck_weights[index] + currentBridgeWeight <= weight ){
                    vBridge.offer(truck_weights[index]);
                    index++;
                } else {
                    vBridge.offer(0);
                } // if - else

            } // if

        } // while


        return timeTaken;
    }
}
