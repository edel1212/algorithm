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

        Queue<Integer> vBridge = new LinkedList<>();

        for(int i = 0 ; i < bridge_length - 1 ; i++ ) vBridge.offer(0);

        // 첫번째 트럭 다리위에 올림
        int currentBridgeWeight = truck_weights[0];
        vBridge.offer(currentBridgeWeight);
        int time = 1;
        // 다음 트럭의 순번
        int index = 1;

        while(!vBridge.isEmpty()){
            time++; // 앞으로 한칸 전진 하므로 시간 ++

            // 다음 칸으로 이동 (다리를 빠져 나감)
            int removeVBride = vBridge.poll();
            // 다리를 빠져 나갔으나 제거
            currentBridgeWeight -= removeVBride;

            // index가 사용 가능한 순번인지 체크
            if( index < truck_weights.length ){

                int newTruck = truck_weights[index];

                // 트럭의 무게를 버틸 수 있는지 확인
                if(newTruck + currentBridgeWeight <= weight){
                    // 현재 다리에 신규 트럭 입장으로 무게 추가
                    currentBridgeWeight += truck_weights[index];
                    // 가상의 다리에 현자 트럭 추가
                    vBridge.offer(truck_weights[index]);
                    // 순번 추가
                    index++;
                } else {
                    // 해당 다음 순번 트럭은 올라 갈 수가 없으므로 0으로 자리를 매꿈
                    vBridge.offer(0);
                } // if

            }// if

        } // while

        return time;
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
