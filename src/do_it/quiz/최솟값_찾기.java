package do_it.quiz;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 최솟값_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        // 배열의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 탐색 범위 (슬라이딩 윈도우 범위)
        int L = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        // 덱 생성
        Deque<Node> deque = new LinkedList<>();

        for(int i = 0 ; i < N; i++){
            // 첫 번째 들어온 값
            int now = Integer.parseInt(stringTokenizer.nextToken());

            // 가장 마지막에 들어온 값과 신규 들어온 값 비교
            while( !deque.isEmpty() && deque.getLast().value > now ){
                // - 신규 들어온 값 보다 큰 값이 있을 경우 삭제
                deque.removeLast();
            } // while

            // 값 추가
            deque.add(new Node( now, i ));

            // 슬라이드 윈도우 범위를 넘어서는 앞의 인덱스 삭제
            if(deque.getFirst().index <= i - L){
                deque.removeFirst();
            } //if

            bw.write(deque.getFirst().value + " ");
        } // for

        bw.flush();
        bw.close();

    }

    // 자료를 담을 Class 생성
    public static class Node{
        // 값
        public int value;
        // 인덱스 순서
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
