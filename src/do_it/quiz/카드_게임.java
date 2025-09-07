package do_it.quiz;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 카드_게임 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 카드의 수 N
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++) queue.offer(i);

        // 조건에 맞게 처리
        while( !queue.isEmpty() && 1 < queue.size()  ){
            // 첫번째 카드는 버림
            queue.poll();
            // 두번째 카드는 추출
            int second = queue.poll();
            // 후 가장 마지막에 저장
            queue.offer(second);
        } // while

        bw.write(String.valueOf(queue.peek()));
        bw.flush();
        bw.close();

    }
}
