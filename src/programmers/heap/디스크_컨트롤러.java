package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    // goal : 1 . 어떤 작업 요청이 들어왔을 때 작업의 번호, 작업의 요청 시각, 작업의 소요 시간을 저장해 두는 대기 큐가 있습니다. 처음에 이 큐는 비어있습니다.
    //        2 . 하드디스크가 작업을 하고 있지 않고 대기 큐가 비어있지 않다면 가장 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다.
    //             -  작업의 " 1 순위 : 소요시간이 짧은 것,
    //                       2 순위 : 작업의 요청 시각이 빠른 것,
    //                       3 순위 : 작업의 번호가 작은 것 순으로 우선순위가 높습니다.
    //        3 . 하드디스크는 작업을 한 번 시작하면 작업을 마칠 때까지 그 작업만 수행합니다.
    // condition : - 1 ≤ jobs의 길이 ≤ 500
    //            - jobs[i]는 i번 작업에 대한 정보이고 [s, l] 형태입니다.
    //            - s는 작업이 요청되는 시점이며 0 ≤ s ≤ 1,000입니다.
    //            - l은 작업의 소요시간이며 1 ≤ l ≤ 1,000입니다.
    public static void main(String[] args){
        int[][] jobs= {{0, 3}, {1, 9}, {3, 5}};
        new 디스크_컨트롤러().solution(jobs);
    }

    public int solution(int[][] jobs) {
        //  작업의 요청 시각 기준 정렬
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        // 우선 순위 Queue 생성 - 작업 순서를 제외한 소요 시간과, 요청 시점을 기준으로 정렬
        // Index0 : 요청 시점
        // Index1 : 작업 소요 시간
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                // 순위에 맞게 작업 작업 요청 시각 비교 후 같을 경우에는 소요 시간 정렬
                (a,b)-> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]
        );

        // 현재 시간
        int currentTime = 0;
        // 실행 프로세스 순번
        int jobIndex = 0;
        int totalTurnaroundTime = 0;
        // 완료된 job
        int completedJobs = 0;

        // 모든 job이 완료 될 때까지 loop
        while( completedJobs < jobs.length ){

            // 지정된 job이 존재하며 요청 시점이 현재 시간보다 작을 경우 대기열 추가
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= currentTime) {
                // 대기열 추가
                priorityQueue.offer(jobs[jobIndex]);
                // 인덱스 증가
                jobIndex++;
            } // loop

            // 큐가 비어 있지 않을 경우 잡을 실행
            if (!priorityQueue.isEmpty()) {
                // 현재의 job 정보
                int[] currentJob = priorityQueue.poll();
                // 현재 시간 + job 실행 시간
                currentTime += currentJob[1];
                // 작업 종료 시각 - 작업 요청 시각
                totalTurnaroundTime += currentTime - currentJob[0];
                // 완료된 작업 추가
                completedJobs++;
            } else {
                // 큐가 비었으면 다음 작업의 요청 시점까지 시간 점프
                currentTime = jobs[jobIndex][0];
            } // if - else
        } // while

        // 총 소요 시간 / job 개수를 통해 평균을 구함
        return totalTurnaroundTime / jobs.length;
    }
}
