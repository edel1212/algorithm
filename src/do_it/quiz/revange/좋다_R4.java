package do_it.quiz.revange;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_R4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ;i++){
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        } // for

        // 정렬
        Arrays.sort(A);

        int result = 0;

        for(int i = 0 ; i < N; i++){
            int compareNum = A[i];

            int start = 0;
            int end = A.length - 1;

            while(start < end){
                int sum = A[start] + A[end];
                if(compareNum == sum){

                    // A[i]가 A[start]와 같은 수인 경우 (즉, i == start), start를 증가시켜 건너뜀
                    if(start == i){
                        start++;
                        continue;
                    }
                    // A[i]가 A[end]와 같은 수인 경우 (즉, i == end), end를 감소시켜 건너뜐
                    if(end == i){
                        end--;
                        continue;
                    }

                    result++;
                    break;
                } else if(sum < compareNum){
                    start++;
                } else{
                    end--;
                } // if - else if
            } // while

        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}
