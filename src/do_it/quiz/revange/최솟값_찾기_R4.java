package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 최솟값_찾기_R4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 수열의 범위
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 슬라이딩 윈도우 범위
        int L = Integer.parseInt(stringTokenizer.nextToken());

        Deque<Node> deque = new ArrayDeque<>();
        stringTokenizer = new StringTokenizer(br.readLine());

        // 주입 받는 값
        for(int i = 0 ; i < N ; i++){
            // 수열의 입력 값
            int value = Integer.parseInt(stringTokenizer.nextToken());

            // 덱이 비어있지 않으며, 덱에 존재하는 가장 마지막 값이 신규 값보다 클 경우 제거 (덱에 최솟값만 존제하게 함)
            // >> 쉬프트 하는 효과
            while(!deque.isEmpty() && deque.getLast().value > value ){
                // 마지막 요소 제거
                deque.removeLast();
            } // while

            deque.add(new Node(i, value));

            // 슬라이딩 윈도우 범위를 벗어나는 요소 제거
            // i 값은 점점 커짐 >> 쉬프트 하기 떄문 그러다보면 처음 값보다 커질 경우 해당 값은 대상에서 벗어나는 것
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
        // 순번 저장
        public int index;
        // 값
        public int value;
        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

}
