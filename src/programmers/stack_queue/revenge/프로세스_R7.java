package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스_R7 {


    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < priorities.length ; i++){
            queue.offer(new int[]{ i,priorities[i] });
        } // for

        while(!queue.isEmpty()){
            boolean hasHigher = false;
            int[] current = queue.poll();

            for(int[] item : queue){
                if( item[1] > current[1] ){
                    hasHigher = true;
                    break;
                } //if
            } // for

            if(hasHigher){
                queue.offer(current);
            } else {
                answer++;
                // 목표 인덱스와 같은 경우 순서 반환
                if( location == current[0] ) return answer;
            } // if - else

        } // while

        return answer;
    }
}
