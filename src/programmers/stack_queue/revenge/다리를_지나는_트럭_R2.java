package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭_R2 {
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
        new 다리를_지나는_트럭_R2().solution(bridge_length, weight, truck_weights);
    }

    //  가상의 Queue  생성 0으로 채움 ( 한대의 트럭이 올라가야하니 해당 부분은 비워 둠 )
    // 1. 트럭 1대 올림
    // 2. 현재 다리위의 무게를 지정
    // 3. 트럭 길이만큼 loop
    // 4. 해당 트럭 길이 만큼 내브에서 트럭의 개수 줄지어 등장 시킴
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer;

        Queue<Integer> vBridge = new LinkedList<>();
        // 현재 트럭을 올려두기 위해 하나릘 제외하고 l-pad 시킴
        for(int i = 0 ; i < bridge_length - 1 ; i++) vBridge.offer(0);

        // 현재 트럭을 가상의 다리 queue에 올려둠
        int currentTruckWeight = truck_weights[0];
        vBridge.offer(currentTruckWeight);
        answer = 1;
        // 첫번째 트럭은 다리위에 올라왔기에 1번부터 시작
        int index = 1;

        while(!vBridge.isEmpty()){
            // 시간 추가
            answer++;
            // 다리위의 트럭 제거
            int outOfBridge = vBridge.poll();
            currentTruckWeight -= outOfBridge;

            if( index < truck_weights.length ){

                int truckWeight = truck_weights[index];
                if( currentTruckWeight + truckWeight <= weight  ){
                    // 다리위 트럭 무게를 올림
                    currentTruckWeight += truckWeight;
                    vBridge.offer(truckWeight);
                    index++;
                } else {
                    vBridge.offer(0);
                } // if - else

            } // if

        } // loop

        return answer;
    }

    public int solution2(int bridge_length, int weight, int[] truck_weights){

        Queue<Integer> vBridge = new LinkedList<>();
        for(int i = 0 ; i < bridge_length -1 ; i++) vBridge.add(0);

        int currentBridgeWeight = truck_weights[0];
        vBridge.offer(currentBridgeWeight);
        int index = 1;
        int time = 1;

        while(!vBridge.isEmpty()){
            // 다리를 지나갈 때마다 시간++
            time++;
            int outTruckByBridge = vBridge.poll();
            currentBridgeWeight -= outTruckByBridge;

            if( index < truck_weights.length ){
                int nextTruck = truck_weights[index];
                // 다음 트럭이 올라와도 다리의 부하를 버틸 수 있을때
                if( nextTruck + currentBridgeWeight <= weight ){
                    // 다리위에 추가
                    vBridge.offer(nextTruck);
                    // 무게 추가
                    currentBridgeWeight += nextTruck;
                    // 다음 순번 추가
                    index++;
                } else{
                    // 다음 트럭이 다리에 올라가 지 못할 경우 가상의 0 추가
                    vBridge.offer(0);
                } // if - else

            } // if

        }// while

        return time;
    }
}
