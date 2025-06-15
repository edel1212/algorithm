package programmers.heap.revenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러_R6 {

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        System.out.println(new 디스크_컨트롤러_R6().solution(jobs));
    }


    public int solution(int[][] jobs) {
        int[][] jobsWithIndex = new int[jobs.length][3];
        for(int i = 0 ; i < jobs.length; i++){
            jobsWithIndex[i][0] = jobs[i][0];
            jobsWithIndex[i][1] = jobs[i][1];
            jobsWithIndex[i][2] = i;
        } // for
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->{
            if(a[1] != b[1]) return a[1] - b[1];
            if(a[0] != b[0]) return a[0] - b[0];
            return a[2] - b[2];
        });

        int totalTime = 0;
        int currentTime = 0;
        int index = 0;
        int completed = 0;

        Arrays.sort(jobs, Comparator.comparingInt(a->a[0]));

        while(completed < jobsWithIndex.length){

            // 작업 대기열 추가
            while( index < jobsWithIndex.length && jobs[index][0] <= currentTime  ){
                heap.offer( jobs[index] );
                index++;
            } // while

            if(!heap.isEmpty()){
                int[] process = heap.poll();
                currentTime += process[1];
                totalTime += currentTime - process[0];
                completed++;
            } else {
                currentTime = jobs[index][0];
            } // if - else

        } // while

        return totalTime / jobs.length;
    }
}
