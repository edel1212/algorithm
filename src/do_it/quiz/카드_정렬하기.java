package do_it.quiz;

import java.io.*;
import java.util.PriorityQueue;

public class 카드_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 카드 묶음 수
        int N = Integer.parseInt(br.readLine());

        // 계속해서 적은 수를 더 해줘야하기에 heap 자료구조 사용
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // 초기 카드 묶음내 카드 개수 주입
        for(int i = 0; i < N ; i++){
            heap.offer(Integer.parseInt(br.readLine()));
        } //for

        int result = 0;
        // 비교는 2개의 요소가 있을때만 함
        while(heap.size() > 1){
            int a = heap.poll();
            int b = heap.poll();
            // 비교 횟수
            int sum = a + b;
            // 만들어진 값을 추가
            heap.offer(sum);
            // 결과 값 저장
            result += sum;
        }//while


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
