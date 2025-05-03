package programmers.stack_queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    // 목적 :  모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며,
    //        다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
    //
    // 조건 : - bridge_length는 1 이상 10,000 이하입니다.
    //       - weight는 1 이상 10,000 이하입니다.
    //       - truck_weights의 길이는 1 이상 10,000 이하입니다.
    //       - 모든 트럭의 무게는 1 이상 weight 이하입니다.
    public static void main(String[] args){
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        System.out.println(new 다리를_지나는_트럭().solution(bridge_length, weight, truck_weights));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridgeQueue = new LinkedList<>();

        // 다리 길이 만큼 Queue 생성 후 l-pad 추가
        for ( int i = 0 ; i < bridge_length - 1 ; i ++ ) bridgeQueue.add(0);

        // 현재 트럭의 무게
        int currentBridgeWeight = truck_weights[0];
        // 현재 트럭을 다리위에 올라감
        bridgeQueue.offer(currentBridgeWeight);

        // 첫번째 트럭이 다리위에 올라 왔으니 1로 시작
        int answer = 1;
        // 한대의 트럭이 시작 됐으므로 1로 시작
        int index = 1;

        while(!bridgeQueue.isEmpty()){
            // 시간 추가
            answer++;

            // 대기 중인 트럭 입장
            int comeNowTruck = bridgeQueue.poll();
            // 현재 다리의 트럭무게에서 제거된 트럭 무게 제거
            currentBridgeWeight -= comeNowTruck;

            // 남은 트럭이 있을 경우
            if( index < truck_weights.length ){

                // 현재 다리에 다음번 트럭이 버틸 수 있는 무게 일 경우
                if( currentBridgeWeight + truck_weights[index] <= weight  ){
                    currentBridgeWeight += truck_weights[index]; // 다리 위 탑승
                    // 다리위 트럭 추가
                    bridgeQueue.add(truck_weights[index]);
                    // 인덱스 상승
                    index++;
                } else {
                    // 트럭이 들어오지 못했으니 다리 길이 만큼의 가상의 0 추가
                    bridgeQueue.add(0);
                } // if - else

            } // if

        } // while

        return answer;
    }

    public int solution2(int bridge_length, int weight, int[] truck_weights) {
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
}
