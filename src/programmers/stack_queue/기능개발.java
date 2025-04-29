package programmers.stack_queue;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {

    // 목적 : 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
    //       각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return
    // 전재 조건 : - 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
    //             이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포
    //           - 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
    //           - 작업 진도는 100 미만의 자연수
    //           - 작업 속도는 100 이하의 자연수
    //           - 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
    //             예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어짐
    public static void main(String[] args){
        기능개발 obj = new 기능개발();
        // int[] progresses = {95, 90, 99, 99, 80, 99};
        // int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(obj.solution(progresses, speeds));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        int progressLength = progresses.length;
        for(int i = 0; i < progressLength; i ++){
            int reminderPercentage =  100 - progresses[i] ;
            int reminderDay = (int) Math.ceil( (double) reminderPercentage / speeds[i] );

            // 함께 배포가 가능한 index 찾기
            int j = i + 1;
            for(; j < progressLength; j++){
                // reminderDay를 기준으로 잡는 이유는 앞에가 끝나야 같이 배포되기 떄문임
                if(progresses[j] + reminderDay * speeds[j] < 100 )
                    break;
            }// for
            answer.add(j - i);
            // j부터 시작하기 떄문 단 -1해주는 이유는 for문 내 i++
            i = j - 1;
        }// for

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        int mainSize = progresses.length;
        for(int i = 0 ; i < mainSize ; i ++){

            int reminderProgress = 100 - progresses[i];
            int reminderDay = (int)  Math.ceil( (double) reminderProgress / speeds[i] );

            int nextIndex = i + 1 ;
            for(; nextIndex < mainSize ; nextIndex++){
                if( progresses[nextIndex] + reminderDay * speeds[nextIndex] < 100 )
                    break;
            } // for
            answer.add(nextIndex - i);
            i = nextIndex - 1;
        }// for

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
