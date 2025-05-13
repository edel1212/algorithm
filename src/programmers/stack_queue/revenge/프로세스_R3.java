package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스_R3 {
    // goal : 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
    //        2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
    //        3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
    //           3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
    public static void main(String[] args){
        int[] priorities = {2, 1, 3, 2};
        int location= 2;
        new 프로세스_R3().solution(priorities, location);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer[]> queue = new LinkedList<>();

        for(int i = 0 ; i < priorities.length ; i++){
            queue.offer(new Integer[]{i, priorities[i]});
        } // for

        while( ! queue.isEmpty()){
            boolean hasHigher = false;
            Integer[] current = queue.poll();

            for(Integer[] item : queue){
                if(current[1] < item[1] ){
                    hasHigher = true;
                    break;
                } // if
            } // for

            if(hasHigher){
                queue.offer(current);
            } else {
                answer++;
                if(location == current[0]) return answer;
            } // if - else
        } // for

        return answer;
    }
}
