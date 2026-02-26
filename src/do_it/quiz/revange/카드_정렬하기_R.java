package do_it.quiz.revange;

import java.io.*;
import java.util.PriorityQueue;

public class 카드_정렬하기_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 가장 적은 카드수를 누적해야하기에 PriorityQueue 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 수열의 개수
        int N = Integer.parseInt(br.readLine());
        // add pq
        for(int i = 0 ; i < N ; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        } // for

        // 누적된 값을 저장할 변수
        int totalSum = 0;

        // 2개 이상 있을 때만 카드를 합칠 수 있음
        while(pq.size() > 1){
            // 앞 카드
            int c1 = pq.poll();
            // 다음 카드
            int c2 = pq.poll();
            // 둘을 더함
            int sum = c1 + c2;
            // 더한 값을 누적합에 더합
            totalSum += sum;
            // 더한 값을 pq에 주입
            pq.offer(sum);
        } // while

        bw.write(String.valueOf(totalSum));
        bw.flush();
        bw.close();
        br.close();
    }
}
