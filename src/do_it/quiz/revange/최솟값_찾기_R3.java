package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 최솟값_찾기_R3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        // 수열의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 지정 범위
        int L = Integer.parseInt(stringTokenizer.nextToken());

        Deque<Node> deque = new ArrayDeque<>();
        stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            int v = Integer.parseInt(stringTokenizer.nextToken());

            // 값 추가
            while(!deque.isEmpty() && deque.getLast().value > v){
                deque.removeLast();
            } // while

            deque.add(new Node(i, v));

            // 값 제거 - 시 공식 확인
            while(!deque.isEmpty() && deque.getFirst().index <= i - L){
                deque.removeFirst();
            } // while

            // 출력
            bw.write(deque.getFirst().value + " ");
        } // for

        bw.flush();
        bw.close();
    }

    public static class Node{
        int index;
        int value;
        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}
