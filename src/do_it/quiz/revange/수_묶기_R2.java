package do_it.quiz.revange;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 수_묶기_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열의 개수
        int N = Integer.parseInt(br.readLine());

        int zeroCount = 0;
        int result = 0;
        // 양수는 클수 록 곱하면 커짐
        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
        // 음수는 작을 수록 곱하면 커짐
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        for(int i = 0 ; i < N ; i++){
            int v = Integer.parseInt(br.readLine());
            if( v == 0 ){
                zeroCount++;
            } else if ( v == 1){
                result++;
            } else if(v > 1){
                plus.offer(v);
            } else {
                minus.offer(v);
            } // if - else if - else
        } // for

        // 양수가 2개 이상일 경우 곱하여 결과에 더해줌
        while(plus.size() > 1){
            result += plus.poll() * plus.poll();
        } // while
        // 나머지 양수 처리
        if(!plus.isEmpty()) result += plus.poll();

        // 음수가 2개일 경우도 같게 처리
        while(minus.size() > 1){
            result += minus.poll() * minus.poll();
        } // while
        // 나머지 음수가 있고  0의 개수가 없다면 그 값을 더해줌 (0이 있다면 둘을 곱해서 상쇄하기에 불필요 코드)
        if(!minus.isEmpty() && zeroCount == 0 ) result += minus.poll();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
