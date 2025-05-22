package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스_R5 {
    public static void main(String[] args){
        int[] priorities = {2, 1, 3, 2};
        int location= 2;
    }

    // goal : 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우 특정 프로세스가 몇 번째로 실행되는지 알아내면 됩니다.
    //        - 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
    //        - 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
    //        - 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
    //          한번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
    public int solution(int[] priorities, int location) {
        Queue<Integer[]> queue = new LinkedList<>();
        for(int i = 0 ; i < priorities.length; i++){
            queue.offer(new Integer[]{i, priorities[i]});
        } // for

        int answer = 0;
        while(!queue.isEmpty()){
            Integer[] current = queue.poll();
            boolean hasHigher = false;

            for(Integer[] q : queue){
                if(current[1] < q[1]){
                    hasHigher = true;
                    break;
                } // if
            } // for

            if(hasHigher){
                queue.offer(current);
            } else {
                answer++;
                if(current[0] == location) return answer;
            } // else

        } // while

        return 0;
    }
}
