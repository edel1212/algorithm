package programmers.heap.revenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러_R2 {

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
        int[][] jobs= {{1, 3}, {10, 9}, {3, 5}};
        new 디스크_컨트롤러_R2().solution(jobs);
    }

    public int solution(int[][] jobs){

        // 총 작업의 개수
        int jobCount = jobs.length;

        // 기존의 job 요소애세 순서를 추가된 2차원 배열 - 작업의 번호 순서를 위함
        int[][] jobWithIndex = new int[jobCount][3];
        for(int i = 0 ; i < jobCount ; i++){
            jobWithIndex[i][0] = jobs[i][0];
            jobWithIndex[i][1] = jobs[i][1];
            jobWithIndex[i][2] = jobs[i][2];
        } // for

        // 작업의 요청 시점으로 정렬 시킴
        Arrays.sort(jobWithIndex, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) ->{
            // 1순위 소요시간 순
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            // 2순위 작업 요청 시간 순
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            // 3순위 작업의 번호 순
            return o1[2] - o2[2];
        });

        // 총 소요 작업 소요시간
        int totalDurationTime = 0;
        // 현재 작업 시간
        int currentDurationTime = 0;
        // 현재 작업중인 작업의 index
        int currentJobIndex = 0;
        // 완료된 작업의 개수
        int completed = 0;

        // 작업이 종료될 때 까지 loop[
        while(completed < jobCount){

            // 실 작업 중인 대기 큐에 넣을 대상 - 요청 시간이 햔재 시간보다 작을 경우 추가 가능
            while( currentJobIndex < jobCount && jobWithIndex[currentJobIndex][0] <= currentDurationTime  ){
                // 대기열 추가
                heap.offer(jobWithIndex[currentJobIndex]);
                // 다음 순번
                currentJobIndex++;
            } // while

            // 작업할게 있는지 확인
            if(!heap.isEmpty()){ // 요청 시간 내 작업할 게 있을 경우
                // 작업을 실행할 대싱을 빼냄
                int[] task = heap.poll();
                // 현재 시간을 작업했던 시간 만큼 추가
                currentDurationTime += task[1];
                // 총 소요시간 추가 ( 총 소요시간 - 요청 시간 )
                totalDurationTime += currentDurationTime - task[0];
                completed++;
            } else { // 요청시간 내 작업할 게 없을 경우
                // 작업 시간을 가장 가장 요청 시간이 낮은에로 변경해줌
                currentDurationTime = jobWithIndex[currentJobIndex][0];
            } // if - else

        } // whiles

        // 평균 값을 반환함
        return totalDurationTime / jobs.length;
    }

    public int solution2(int[][] jobs){
        int jobCount = jobs.length;

        int[][] jobWithIndex = new int[jobCount][3];
        for(int i = 0; i < jobCount ; i++){
            jobWithIndex[i][0] = jobs[i][0];
            jobWithIndex[i][1] = jobs[i][1];
            jobWithIndex[i][2] = i;
        } // for

        // 작업의 요청 순서 오름 차순 정렬 - heap에 저장 전 대기 heap에 비교 시 사용됨
        Arrays.sort(jobWithIndex, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1,o2)->{
            // 1순위
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            // 2순위
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            // 3순위
            return o1[2] - o2[2];
        });

        int completed = 0;
        int currentDurationIndex = 0;
        int currentDurationTime = 0;
        int totalDurationTime = 0;

        while(completed < jobCount){

            while( currentDurationIndex < jobCount && jobWithIndex[currentDurationIndex][0] <= currentDurationTime ){
                heap.offer(jobWithIndex[currentDurationIndex]);
                currentDurationIndex++;
            } // while

            if(!heap.isEmpty()){
                int[] task = heap.poll();
                currentDurationTime += task[1];
                totalDurationTime += currentDurationTime - task[0];
                completed++;
            } else { // 다음 작업의 실핼 시간이 이전 요청시간 + 작업 시간 보다 훨씬 실경우 해당 else문이 사용됨
                currentDurationTime = jobWithIndex[currentDurationIndex][0];
            } // if - else

        } // while

        return totalDurationTime / jobCount;
    }
}
