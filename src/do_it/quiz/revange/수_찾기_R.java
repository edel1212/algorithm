package do_it.quiz.revange;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수_찾기_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 대상 배열 수열의 길이
        int N = Integer.parseInt(br.readLine());
        // base array init
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }//for
        // 정렬
        Arrays.sort(A);

        // 찾으려는 대상 수열의 길이
        int M = Integer.parseInt(br.readLine());
        int[] T = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            T[i] = Integer.parseInt(st.nextToken());
        }//for

        // 이진 탐색 시작
        StringBuilder sb = new StringBuilder();
        for(int target : T){
            int start = 0;
            int end = N - 1;
            boolean isFind = false;

            // 완벽하게 겹쳐졌을 때까지 loop
            while(start <= end){
                // 대상 중심 index
                int mid = (start + end) / 2;

                if(target == A[mid]){
                    isFind = true;
                    break;
                } // if

                if(target >= A[mid]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                } // if - else

            } // while

            // 값을 찾았을 경우
            if(isFind){
                sb.append("1");
            } else {
                sb.append("0");
            } // if - else
            sb.append("\n");
        } // for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
