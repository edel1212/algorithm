package do_it.quiz;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 수_묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 2이상의 수를 담을 heap
        PriorityQueue<Integer> plusHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // 음수를 담을 heap
        PriorityQueue<Integer> minusHeap = new PriorityQueue<>();
        // 1의 개수
        int one = 0;
        // 0의 개수
        int zero = 0;

        for(int i = 0 ; i < N ; i++){
            int v = Integer.parseInt(br.readLine());
            if(v > 1){ // 1초과
                plusHeap.offer(v);
            } else if (v == 1){ // is 1
                one++;
            } else if(v == 0){ // is 0
                zero++;
            } else { // is under 0
                minusHeap.offer(v);
            } // if - else-if - else
        }// for

        long result = 0;

        // 양수 2개 이상일 경우
        while(plusHeap.size() > 1){
            int o1 = plusHeap.poll();
            int o2 = plusHeap.poll();
            result += o1 * o2;
        } // while
        // 나머지 처리
        while(!plusHeap.isEmpty()){
            result += plusHeap.poll();
        } // while

        // 음수 2개 이상일 경우
        while(minusHeap.size() > 1){
            int o1 = minusHeap.poll();
            int o2 = minusHeap.poll();
            result += o1 * o2;
        } // while

        // 나머지 처리
        if (!minusHeap.isEmpty()) {
            int lastNeg = minusHeap.poll();
            if (zero == 0) {
                result += lastNeg;
            } else {
                zero--;
            }// if -else
        } // if


        result += one;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
