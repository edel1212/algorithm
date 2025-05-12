package programmers.stack_queue.revenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발_R4 {
    public static void main(String[] args){
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        new 기능개발_R4().solution(progresses, speeds);
    }

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length ; i++){
            int reminderPercentage = 100 - progresses[i];
            int reminderDay = (int) Math.ceil((double) reminderPercentage / speeds[i]);
            queue.offer(reminderDay);
        } //for

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            int deployCnt = 1;
            int currentReminderDay = queue.poll();
            while(!queue.isEmpty() && currentReminderDay >= queue.peek() ){
                queue.poll();
                deployCnt++;
            }
            result.add(deployCnt);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
