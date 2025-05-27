package programmers.stack_queue.revenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발_R5 {
    public static void main(String[] args){
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        new 기능개발_R5().solution(progresses, speeds);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            int remainderPercentage = 100 - progresses[i];
            int remainderDay = (int) Math.ceil( (double) remainderPercentage / speeds[i]  );
            queue.offer(remainderDay);
        } // for

        while(!queue.isEmpty()){
            int currentProcess = queue.poll();
            int deployCnt = 1;

            while(!queue.isEmpty() && currentProcess >= queue.peek()){
                deployCnt++;
                queue.poll();
            }

            answer.add(deployCnt);
        } // while

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
