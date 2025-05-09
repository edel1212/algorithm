package programmers.stack_queue.revenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발_R3 {
    public static void main(String[] args){
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        new 기능개발_R3().solution(progresses, speeds);
    }

    // 1. 남은 날짜 계선 후 Queue에 저장
    // 2. 날짜 변수 생성
    // 3. 인덱스 변수 추가 - 1 로 시작
    // 4. 해당 Queue를 돌면서 첫번째 날짜 poll
    // 5. 배열이 null 이 아닐 경우
    //    - peek 후 비교 poll 한값이 더 크면 해당 값 같이 배포 가능
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < progresses.length; i++){
            int reminderPercentage = 100 - progresses[i];
            int reminderDay = (int) Math.ceil(  (double) reminderPercentage / speeds[i] );
            queue.offer(reminderDay);
        } //for

        int deployCnt = 1;

        while(!queue.isEmpty()){
            int baseDay = queue.poll();
            // 2일 남음 < 1일남음
            while( !queue.isEmpty() &&  queue.peek() <=  baseDay  ){
                deployCnt++;
                queue.poll();
            } //
            answer.add(deployCnt);
            deployCnt = 1;
        } // while

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
