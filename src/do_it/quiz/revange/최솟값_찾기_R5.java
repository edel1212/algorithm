package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 최솟값_찾기_R5 {
    public static void main(String[] args)   throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 수열의 범위
        int N = Integer.parseInt(st.nextToken());
        // 슬라이딩 윈도우 범위
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            // 입력 받은 값
            int v = Integer.parseInt(st.nextToken());

            // 가장 작은 값을 유지하는 것이 목표이다.
            while(!deque.isEmpty() && deque.getLast().value > v){
                // 마지막 값 제거
                deque.removeLast();
            } // while

            deque.add(new Node(i, v));

            while(!deque.isEmpty() && deque.getFirst().index <= i - L){
                // 가장 앞에 값 제거
                deque.removeFirst();
            } //while

            // 출력
            bw.write(deque.getFirst().value + " ");

        } // for


        bw.flush();
        bw.close();
    }


    public static class Node{
        public int index;
        public int value;

        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

}
