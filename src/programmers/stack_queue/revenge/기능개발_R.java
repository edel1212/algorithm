package programmers.stack_queue.revenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발_R {
    // goal : 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
    //        각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포
    //        먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution
    // condition : 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
    //             작업 진도는 100 미만의 자연수입니다.
    //             작업 속도는 100 이하의 자연수입니다.
    public static void main(String[] args){

    }

    // 1. 큐에 담는다.
    // 3. index를 알 수 있는 변수 등록
    // 2. poll과 peek을 통한 비교 100이 넘는지 확인

    public int[] solution(int[] progresses, int[] speeds){
        List<Integer> answer = new ArrayList<>();

        int progressLength = progresses.length;

        for(int idx = 0 ; idx < progressLength; idx++){

            int reminderPercentage = 100 - progresses[idx];
            int reminderDay = (int) Math.ceil( (double) reminderPercentage / speeds[idx]  );

            int nextProgress = idx + 1;
            for(; nextProgress < progressLength; nextProgress++){
                if(progresses[nextProgress] + reminderDay * speeds[nextProgress] < 100)
                    break;
            } // for

            answer.add(nextProgress - idx);

            idx = nextProgress - 1;

        } // for

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
