package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수_찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }//for

        // 바이너리 탐색 필수 - 정렬
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            boolean isFind = false;
            // 찾아야 하는 값
            int target = Integer.parseInt(stringTokenizer.nextToken());

            // 이진 탐색
            int start = 0;
            int end = A.length - 1;
            while(start <= end){
                int mid = (start + end) / 2;
                if( A[mid] < target ){
                    start = mid + 1;
                } else if(A[mid] > target){
                    end = mid - 1;
                } else {
                    isFind = true;
                    break;
                } // if -else
            }// while

            String result = isFind ? "1" : "0";
            bw.write(result);
            bw.newLine();
        }// for

        bw.flush();
        bw.close();
    }


}
