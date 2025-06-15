package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스_R8 {

    public static void main(String[] args) {
        new 프로세스_R8().solution(new int[]{2,1,3,2}, 2);
    }

    public int solution(int[] priorities, int location) {
        // index를 보유한 priorities queue 생성
        // while loop를 돌면서 해당 값보다 큰게 있는지 확인하고 있을 경우 현재 큐를 다시 넣음

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i ++){
            queue.offer(new int[]{i, priorities[i]});
        } // for

        int completeCnt = 0;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            boolean hasHigher = false;


            for(int[] item : queue){
                if( current[1] < item[1] ){
                    hasHigher = true;
                    break;
                } // if
            } // for

            if(hasHigher){
                queue.offer(current);
            } else {
                completeCnt++;
                if( location == current[0] ) return completeCnt;
            } // else

        } // for

        return 0;
    }
}
