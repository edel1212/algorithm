package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭_R5 {
    // goal :  모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
    //          다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
    //          단, 다리에 완전히 오르지 않은 트럭의 무게는 무시
    // condition : bridge_length는 1 이상 10,000 이하입니다.
    //             weight는 1 이상 10,000 이하입니다.
    //             truck_weights의 길이는 1 이상 10,000 이하입니다.
    //             모든 트럭의 무게는 1 이상 weight 이하입니다.
    public static void main(String[] args){
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = { 7,4,5,6 };
    }
    public int solution(int bridge_length, int weight, int[] truck_weights){
        Queue<Integer> vBridge = new LinkedList<>();
        for(int i = 0 ; i < bridge_length - 1 ; i++) vBridge.offer(0);
        int currentBridgeWeight = truck_weights[0];
        vBridge.offer(currentBridgeWeight);

        int truckIndex = 1;
        int time = 1;

        while(!vBridge.isEmpty()){
            time++;
            int nextMove = vBridge.poll();
            currentBridgeWeight -= nextMove;

            if(truckIndex < truck_weights.length){
                int nextTruck = truck_weights[truckIndex];
                if(currentBridgeWeight + nextTruck <= weight){
                    currentBridgeWeight += nextTruck;
                    vBridge.offer(nextTruck);
                    truckIndex++;
                } else{
                    vBridge.offer(0);
                } // if -else

            } // if

        } // while

        return time;
    }
}
