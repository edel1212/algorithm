package do_it.quiz.revange;

import java.io.*;
import java.util.PriorityQueue;

public class 수_묶기_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> plushHeap = new PriorityQueue<>((a,b)-> b-a);
        PriorityQueue<Integer> minusHeap = new PriorityQueue<>();
        int oneCount = 0;
        int zeroCount = 0;

        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ;i++){
            int v = Integer.parseInt(br.readLine());
            if(v == 1){
                oneCount++;
            } else if (v > 1){
                plushHeap.offer(v);
            } else if(v < 0){
                minusHeap.offer(v);
            } else {
                zeroCount++;
            }// if - else
        } // for

        int result = 0;

        // 2개 이상일 경우
        while(plushHeap.size() > 1){
            int o1 = plushHeap.poll();
            int o2 = plushHeap.poll();
            result += o1 * o2;
        } // while

        // 나머지 처리
        while (!plushHeap.isEmpty()){
            result += plushHeap.poll();
        } //while

        // 2개 이상일 경우
        while(minusHeap.size() > 1){
            int o1 = minusHeap.poll();
            int o2 = minusHeap.poll();
            result += o1 * o2;
        } // while

        // 나머지 처리
        while (!minusHeap.isEmpty()){
            if(zeroCount > 0){
                result += minusHeap.poll() * 0;
                zeroCount--;
                continue;
            }//if
            result += minusHeap.poll();
        } //while

        // 나머지 1의 나온 개수를 더 해줌
        result += oneCount;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
