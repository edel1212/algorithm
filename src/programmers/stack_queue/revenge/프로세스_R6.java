package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스_R6 {
    public int solution(int[] priorities, int location) {
        int prioritiesSize = priorities.length;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < prioritiesSize ; i++) queue.offer(new int[]{ i, priorities[i] });

        int count = 0;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            boolean hasHigher = false;
            // 뒤에 더 높은 값이 있는지 확인
            for(int[] job : queue){
                if(current[1] < job[1]){
                    hasHigher = true;
                    break;
                } //if
            }// for

            if(hasHigher){
                queue.offer(current);
            } else {
                count++;
                if( current[0] + 1 == location ) return count;
            } // if - else

        }// while

        return 0;
    }
}
