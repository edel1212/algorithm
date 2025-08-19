package programmers.stack_queue.revenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발_R7 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> remainderDays = new LinkedList<>();

        for(int i = 0 ; i < progresses.length ; i++){
            int remainderPercentage = 100 - progresses[i];
            int remainderDay = (int) Math.ceil( remainderPercentage / speeds[i]);
            remainderDays.offer(remainderDay);
        } // for

        while(!remainderDays.isEmpty()){
            int deployCount = 1;
            int current = remainderDays.poll();

            while(!remainderDays.isEmpty() && remainderDays.peek() <= current ){
                remainderDays.poll();
                deployCount++;
            } // if

            answer.add(deployCount);
        } // while

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
