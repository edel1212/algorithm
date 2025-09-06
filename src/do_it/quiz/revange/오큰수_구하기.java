package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 오큰수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] seqArr = new int[N];
        int[] result = new int[N];
        Deque<Integer> indexStack = new ArrayDeque<>();

        // seq arr init
        String[] seqStr = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i ++) seqArr[i] = Integer.parseInt(seqStr[i]);

        // stack init setting
        // 첫 번째 0 초기 값 세팅
        indexStack.push(0);

        // 초기 세팅 0번 Index를 했기에 1부터 시작
        for(int i = 1 ; i < N ; i++){

            // 이전 값(stack index 값) 보다 옆 값이 클 경우
            while( !indexStack.isEmpty() && seqArr[indexStack.peek()] < seqArr[i] ){
                result[ indexStack.pop() ] = seqArr[i];
            } // while

            indexStack.push(i);
        } // for

        // 할당 되지 못한 Index 값이 남아있을 경우
        while(!indexStack.isEmpty()){
            result[indexStack.pop()] = -1;
        } // while

        // 출력
        for(int r : result){
            bw.write(r + " ");
        } // for
        bw.flush();
        bw.close();
    }
}
