package programmers.stack_queue.revenge;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스_R {
    // goal : 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우 특정 프로세스가 몇 번째로 실행되는지 알아내면 됩니다.
    //        - 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
    //        - 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
    //        - 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
    //          한번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
    public static void main(String[] args){
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location= 0;
        System.out.println(new 프로세스_R().solution(priorities, location));
    }

    // 1. 우선 순위 큐에 넣는다.
    // 2. 큐가 없어질때까지 loop를 돈다
    // 3. priorities 기준으로 for문을 골린다.
    // 만약 내가 정한 location의 위치 값과 같을 경우 return
    //
    public int solution(int[] priorities, int location){
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();

        // queue에 값을 담아 둠
        for(int index = 0 ; index < priorities.length; index++){
            queue.offer(new int[]{ index , priorities[index] });
        } // for

        while(!queue.isEmpty()){
            // 최고 앞의 값
            int[] current = queue.poll();
            // 더 높은 순위의 프로세스 확인 flag
            boolean hasHigherPriority = false;

            // 한개가 빠진 Queue loop ( 내 뒤에 더 높은 수가 있는지 체크하는 로직 )
            for(int[] item : queue){
                // 앞의 값이 더 높은게 있는지 체크
                if(item[1] > current[1]){
                    hasHigherPriority = true;
                    break;
                } // if
            } // for

            if(hasHigherPriority){
                // 더 큰 값이 있을 경우 뒤로 보내
                queue.offer(current);
            } else{
                // 실질 적으로 순서가 맞게 정렬이 된 이후 해당 index 번호와 location 순서가 같을 경우만 찾아 줌
                answer++;
                if (current[0] == location)  return answer;
            } // if - else

        } // while

        return answer;
    }
}
