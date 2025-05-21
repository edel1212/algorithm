package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스_R4 {
    public static void main(String[] args){
        int[] priorities = {2, 1, 3, 2};
        int location= 2;
    }

    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i ++) queue.offer(new int[]{i, priorities[i]});
        int answer = 0;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            boolean isHigher = false;
            for(int[] item : queue){
                if( current[1] < queue.peek()[1]  ){
                    isHigher = true;
                    break;
                }
            } // for

            if(isHigher){
                answer++;
                queue.offer(current);
            } else {
                if(current[0] == location ) return answer;
            } // else
        } // while

        return answer;
    }

}
