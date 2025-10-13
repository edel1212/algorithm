package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 최솟값_찾기_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int L = Integer.parseInt(tokenizer.nextToken());

        Deque<Node> deque = new ArrayDeque<>();

        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){

            int v = Integer.parseInt(tokenizer.nextToken());

            // 가장 마지막에 들어온 값이 새로 들어온 값보다 클 경우 제거
            while(!deque.isEmpty() && deque.getLast().value > v ){
                deque.removeLast();
            } // if

            deque.add(new Node(i, v));

            // 인덱스 범위를 벗어난 값
            if(deque.getFirst().index <= i - L ){
                deque.removeFirst();
            } // if


            bw.write(deque.getFirst().value + " ");
        } // while

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
