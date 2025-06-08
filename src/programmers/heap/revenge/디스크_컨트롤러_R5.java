package programmers.heap.revenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러_R5 {

    public int solution(int[][] jobs) {
        int jobSize = jobs.length;

        int[][] jobsWithIdx = new int[jobSize][3];
        for(int i = 0; i < jobSize; i++){
            jobsWithIdx[i][0] = jobs[i][0];
            jobsWithIdx[i][1] = jobs[i][1];
            jobsWithIdx[i][2] = i;
        } // for
        Arrays.sort(jobsWithIdx, Comparator.comparingInt((a)->a[0]));

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) ->{
            if(a[1]!=b[1]) return a[1] - b[1];
            if(a[0]!=b[0]) return a[0] - b[0];
            return a[2] - b[2];
        });

        int totalTime = 0;
        int currentTime = 0;
        int currentIdx = 0;
        int completed = 0;

        while(completed < jobSize){

            while( currentIdx < jobSize && jobsWithIdx[currentIdx][0] <= currentTime ){
                heap.offer(jobsWithIdx[currentIdx]);
                currentIdx++;
            } // while

            if( !heap.isEmpty() ){
                int[] process = heap.poll();
                currentTime += process[1];
                totalTime += currentTime - process[0];
                completed++;
            } else {
                currentTime = jobsWithIdx[currentIdx][0];
            } // else

        } // while

        return totalTime / jobSize;
    }
}
