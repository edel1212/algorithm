package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 카드2_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 수열의 범위 ( 1 ~ N )
        int N = Integer.parseInt(br.readLine());

        // add
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1 ; i <= N ; i++){
            deque.add(i);
        } // for

        // 1. 조건 가장 처음 값 제거
        // 2. 가장 앞의 값 가장 밑으로 이동
        // 3. 카드가 마지막 한장 남을 때 까지 반복
        while (deque.size() > 1){
            // 가장 첫 카드 삭제
            deque.removeFirst();
            // 두번째 카드 추출
            int v = deque.poll();
            deque.add(v);
        } // while

        bw.write(String.valueOf(deque.getFirst()));
        bw.flush();
        bw.close();
        br.close();

    }
}
