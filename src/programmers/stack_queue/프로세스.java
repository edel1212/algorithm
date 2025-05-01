package programmers.stack_queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프로세스 {
    // 목적 : 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우 특정 프로세스가 몇 번째로 실행되는지 알아내면 됩니다.
    //      - 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
    //      - 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
    //      - 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
    //        - 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
    public static void main(String[] args){
        int[] priorities = {2, 1, 1, 3, 2};
        int location = 2;
        프로세스 obj = new 프로세스();
        System.out.println(obj.solution(priorities, location));
    }

    public int solution(int[] priorities, int location){
        int answer = 0;
        // 우선 순위 queue 생성 및 추가
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int prior : priorities ) priorityQueue.offer(prior);

        // 내림 차순 정렬된 Queue Loop -  3, 2, 2, 1, 1
        while(!priorityQueue.isEmpty()){

            // Loop  priorities - 2, 1, 1, 3, 2
            for( int i = 0; i < priorities.length ; i++ ){

                System.out.println("priorityQueue.peek() :: " + priorityQueue.peek());
                System.out.println("priorities["+i+"] :: " + priorities[i]);
                if( priorityQueue.peek() == priorities[i] ){
                    answer++;
                    priorityQueue.poll();
                    if( location == i ) return answer;
                } // if

            }// loop

        } // loop

        return answer;
    }

    public int solution2(int[] priorities, int location){
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int item : priorities) priorityQueue.offer(item);

        while(!priorityQueue.isEmpty()){

            for(int i = 0 ; i < priorities.length ; i++){

                if( priorityQueue.peek() == priorities[i] ){
                    answer++;
                    priorityQueue.poll();
                    if( i == location ) return answer;
                }// if

            }// for

        }// while

        return answer;
    }


}
