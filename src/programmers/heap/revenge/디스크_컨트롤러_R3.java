package programmers.heap.revenge;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러_R3 {

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        System.out.println(new 디스크_컨트롤러_R3().solution(jobs));
    }


    // 0 . 비어 있는 우선순위에 맞게 정렬되는 heap 생성
    // 1 . 우선순위에 맞는 job 생성
    // 2 . 작업순위가 비어있다면 바로 다음 작업 시작
    // 4 . 반환 시간은 작업 종료 시간 - 요청 시간
    // 5 . 해당 작업을 토대로 평균값을 반환함
    //
    // loop 조건 : 모든 작업이 끝나야함
    public int solution(int[][] jobs) {
        int jobSize = jobs.length;

        // index번호를 갖고 있는 2차원 배열 생성
        int[][] jobWidthIndex = new int[jobSize][3];
        for(int i = 0; i < jobSize ; i ++){
            jobWidthIndex[i][0] = jobs[i][0];
            jobWidthIndex[i][1] = jobs[i][1];
            jobWidthIndex[i][2] = i;
        }// for
        /// 작업의 우선순위에 맞게 정렬
        Arrays.sort(jobWidthIndex, Comparator.comparingInt(a -> a[0]));

        // 조건에 맞는 heap 생성
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->{
            if(a[1] != b[1]) return a[1] - b[1];
            if(a[0] != b[0]) return a[0] - b[0];
            return a[2] - b[2];
        });

        // 완료된 작업의 개수
        int completed = 0;
        // 작업대상 index
        int currentIndex = 0;
        // 현재작업 시간
        int currentTime = 0;
        // 총 작업 시간
        int totalTime = 0;

        // 작업이 종료될 때 까지 loop
        while(completed < jobSize){

            // ❌ 해당 방법은 하나의 heap만 주입함 범위 내의 모든 작업을 힘에 주입 필요  :  if( jobWidthIndex[currentIndex][0] <= currentTime)
            while (currentIndex < jobSize && jobWidthIndex[currentIndex][0] <= currentTime) {
                heap.offer(jobWidthIndex[currentIndex]);
                currentIndex++;
            }

            if(!heap.isEmpty()){
                int[] current = heap.poll();
                currentTime += current[1];
                totalTime += currentTime - current[0];
                completed++;
            } else {
                currentTime = jobWidthIndex[currentIndex][0];
            } // if - else

        } // while

        return totalTime / jobSize;
    }
}
