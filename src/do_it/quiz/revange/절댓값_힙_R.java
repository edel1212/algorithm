package do_it.quiz.revange;

import java.io.*;
import java.util.PriorityQueue;

public class 절댓값_힙_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열의 개수
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> heap = new PriorityQueue<>((a,b)-> {
            if(a.value == b.value){
                return a.origin - b.origin;
            }// if
            return a.value - b.value;
        });

        for(int i = 0 ; i < N ;i++){
            int input = Integer.parseInt(br.readLine());

            if(input == 0){
                if(heap.isEmpty()){
                    bw.write("0");
                } else {
                    bw.write(String.valueOf(heap.poll().origin));
                } // if - else
                bw.newLine();
                continue;
            } // if

            heap.offer(new Node(Math.abs(input), input));

        } // for

        bw.flush();
        bw.close();
    }

    public static class Node{
        public int value;
        public int origin;

        public Node(int value, int origin){
            this.value = value;
            this.origin = origin;
        }
    }
}
