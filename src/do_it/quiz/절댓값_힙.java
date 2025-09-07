package do_it.quiz;

import java.io.*;
import java.util.PriorityQueue;

public class 절댓값_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>( (a,b) ->{
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA == absB) {
                return Integer.compare(a, b); // 절대값 같으면 실제 값 작은 순서
            }

            return Integer.compare(absA, absB); // 절대값 작은 순서
        } );

        for (int i = 0 ; i < N ; i++){
            int M = Integer.parseInt(br.readLine());
            if( M == 0 ){
                if(heap.isEmpty()){
                    bw.write("0");
                    bw.newLine();
                } else {
                    bw.write(String.valueOf(heap.poll()));
                    bw.newLine();
                } // if - else
                continue;
            }// if

            // 값 추가
            heap.offer(M);

        } // for

        bw.flush();
        bw.close();
    }
}
