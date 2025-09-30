package do_it.quiz.revange;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 최솟값_찾기_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        // 배열의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 탐색 범위 (슬라이딩 윈도우 범위)
        int L = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(br.readLine(), " ");

        // 덱 생성 - 앞 뒤 삭제가 가능함
        Deque<Node> deque = new LinkedList<>();

        for(int i = 0 ; i < N ; i++){
            int now = Integer.parseInt(stringTokenizer.nextToken());

            // 가장 마지막에 들어온 값과 신규 들어온 값을 비교
            while( !deque.isEmpty() && deque.getLast().value > now){
                // 마지막 요소 삭제
                deque.removeLast();
            } // while

            // 값 추가
            deque.add(new Node(now, i));

            // 범위를 넘어서면 강제 삭제
            if(deque.getFirst().index <= i -L){
                deque.removeFirst();
            }// if

            bw.write(String.valueOf(deque.getFirst() + " "));

        } //for

        bw.flush();
        bw.close();
    }

    public static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
