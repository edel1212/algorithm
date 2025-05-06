package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭_R {

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
        new 다리를_지나는_트럭_R().solution(bridge_length, weight, truck_weights);
    }

    // solution : 가상의 다리를 만듬
    //            해당 다리에 첫번째 트력 진입
    //            다 다리 위 차량의 무게가 버틸 수 있을 경우 하나 더 올림 반복
    public int solution(int bridge_length, int weight, int[] truck_weights){
        int answer = 0;

        Queue<Integer> vBridge = new LinkedList<>();
        for( int i = 0 ; i < bridge_length - 1 ; i++ ) vBridge.offer(0);

        // 첫번째 차량 진입
        vBridge.offer(truck_weights[0]);
        // 다리 위 차량 무게 +
        int currentBridgeWeight = truck_weights[0];
        // 차량이 올랐으므로 시간 추가
        answer = 1;
        // 위치 추적을 위한 index ( 트럭이 올라갔으므로 1로 시작 )
        int index = 1;

        // 가상 다리를 기준으로 loop
        while(!vBridge.isEmpty()){
            answer++;
            // 다음 칸으로 트럭 전신
            int moveToTruck = vBridge.poll();
            currentBridgeWeight -= moveToTruck;

            // 트럭의 개수가 초과하지 않기 위한 체크
            if(index < truck_weights.length){

                int nowOnBridgeTruckWeight = truck_weights[index];

                // 기존의 다리 무게 + 새로 들어온 트럭의 무케를 버티는지 확인
                if( nowOnBridgeTruckWeight + currentBridgeWeight <= weight ){
                    currentBridgeWeight += truck_weights[index];
                    vBridge.offer(truck_weights[index]);
                    index++;
                } else {
                    // 다리위에 트럭을 추가 할 수 없으니 다시 해당 챠량의 칸을 0으로 채움
                    vBridge.offer(0);
                } // if -else

            } // if

        } // while


//        Queue<Integer> truck = new LinkedList<>();
//        for( int i = 1 ; i < truck_weights.length  ; i++ ) truck.offer(truck_weights[i]);
//
//        while(!truck.isEmpty()){
//            int nextTruck = truck.peek();
//            answer++;
//            currentBridgeWeight += nextTruck;
//            if( !vBridge.isEmpty() && vBridge.size() <= bridge_length && currentBridgeWeight <= weight){
//                truck.poll();
//            } else {
//                currentBridgeWeight -= nextTruck;
//            } // if -else
//
//        } // while

        return answer;
    }
}
