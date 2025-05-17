package programmers.heap.revenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크_컨트롤러_R {
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
    //               [요청되는 시점, 소요시간] 형태입니다.
    public static void main(String[] args){
        int[][] jobs= {{0, 3}, {10, 9}, {3, 5}};
        new 디스크_컨트롤러_R().solution(jobs);
    }

    public int solution(int[][] jobs) {
        // 작업의 전체 개수
        int jobCnt = jobs.length;

        // 기존 job에 index 를 추가하여 관리함
        int[][] jobsWithIndex = new int[jobCnt][3];
        for(int idx = 0; idx < jobCnt ; idx++){
            jobsWithIndex[idx][0] =  jobs[idx][0];
            jobsWithIndex[idx][1] =  jobs[idx][1];
            jobsWithIndex[idx][2] =  idx;
        } // for

        // 요청 시점 순 정렬 - 시작은 요청 시작순으로 들어가기 때문임 ( 실작업은 우선순위 Queue로 시작 )
        Arrays.sort(jobsWithIndex, Comparator.comparingInt(a -> a[0]));

        // 우선 순위 큐 생성
        PriorityQueue<int[]> heap = new PriorityQueue<>( (o1 ,o2) ->{
            // 1순위 소요시간
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            // 2순위 요청 시점
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            // 3순위 작업 번호
            return o1[2] - o2[2];
        } );

        // 총 소요 시간
        int totalTime = 0;
        // 진행 중인 시간
        int time = 0;
        // 현재 작업 인덱스
        int jobIndex = 0;
        // 완료된 작업
        int completed = 0;

        // 모든 작업이 완료 될 때까지 loop
        while( completed < jobCnt ){

            // 실행할 작업 추가
            while( jobIndex < jobCnt && jobsWithIndex[jobIndex][0] <= time ){
                heap.offer(jobsWithIndex[jobIndex]);
                jobIndex++;
            }// while

            if(!heap.isEmpty()){
                int[] currentJob = heap.poll();
                time += currentJob[1];
                // 실행 시간 - 요청 시간 ( pending된 시간을 빼서 실제 실행된 시간만 구함 )
                totalTime += time - currentJob[0];
                // 완료 개수 추가
                completed++;
            } else{
                // time에 들어온 값의 요청 시간을 넣어줌
                time = jobsWithIndex[jobIndex][0];
            } // if - else

        } // while


        return totalTime / jobCnt;
    }
}

