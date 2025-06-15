package programmers.stack_queue.revenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발_R6 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length ; i ++){
            int remainderPercentage = 100 - progresses[i];
            // 70 30  === 3일 필요
            int remainderDay = (int) Math.ceil( (double) remainderPercentage / speeds[i] );
            queue.offer(remainderDay);
        } // for

        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()){
            int deployCnt = 1;
            int current   = queue.poll();
            while( !queue.isEmpty() && queue.peek() <= current ){
                queue.poll();
                deployCnt++;
            } //for
            answer.add(deployCnt);
        } // for

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
