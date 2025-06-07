package programmers.heap.revenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러_R4 {

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        System.out.println(new 디스크_컨트롤러_R4().solution(jobs));
    }

    public int solution(int[][] jobs) {
        int jobSize = jobs.length;
        int[][] jobWithIdx = new int[jobSize][3];

        for(int i = 0 ; i < jobSize; i++){
            jobWithIdx[i][0] = jobs[i][0];
            jobWithIdx[i][1] = jobs[i][1];
            jobWithIdx[i][2] = i;
        } // for
        Arrays.sort(jobWithIdx, Comparator.comparingInt(a->a[0]));

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->{
           if( a[1] != b[1] ) return a[1] - b[1];
           if( a[0] != b[0] ) return a[0] - b[0];
           return a[2] - b[2];
        });

        int totalTime = 0;
        int currentTime = 0;
        int currentIdx = 0;
        int completed = 0;

        while(completed < jobSize){

            while( currentIdx < jobSize && jobWithIdx[currentIdx][0] <= currentTime ){
                heap.offer(jobWithIdx[currentIdx]);
                currentIdx++;
            } // while

            if(!heap.isEmpty()){
                int[] process = heap.poll();
                currentTime += process[1];
                totalTime += currentTime - process[0];
                completed++;
            } else {
                currentTime = jobWithIdx[currentIdx][0];
            } // if - else

        } // while

        return totalTime / jobSize;
    }
}
