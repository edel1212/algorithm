package programmers.stack_queue.revenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발_R2 {
    public static void main(String[] args){
        int[] progresses = {};
        int[] speeds = {};
        new 기능개발_R2().solution(progresses, speeds);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> daysQueue = new LinkedList<>();
        for(int i = 0 ; i < progresses.length; i++){
            int reminderPercentage = 100 - progresses[i];
            int day = (int) Math.ceil( (double) reminderPercentage / speeds[i]  );
            daysQueue.offer(day);
        } // for

        while(!daysQueue.isEmpty()){
            int current = daysQueue.poll();
            int count = 1;

            // 다음 작업들이 current일 이내로 끝나면 함께 배포
            while (!daysQueue.isEmpty() && daysQueue.peek() <= current) {
                daysQueue.poll();
                count++;
            } // while

            answer.add(count);

        } // while

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int[] progresses, int[] speeds){
        List<Integer> answer = new ArrayList<>();

        int progressSize = progresses.length;

        for(int idx = 0 ; idx < progressSize ; idx++){
            int reminderPercentage = 100 - progresses[idx];
            int reminderDay = (int) Math.ceil( (double) reminderPercentage / speeds[idx]  );

            int nextProgress = idx + 1;
            for(; nextProgress < progressSize ; nextProgress++){

                if( progresses[nextProgress] + reminderDay * speeds[nextProgress] < 100 )
                    break;

            } // for
            answer.add(nextProgress - idx);
            idx = nextProgress - 1;
        } // for

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
