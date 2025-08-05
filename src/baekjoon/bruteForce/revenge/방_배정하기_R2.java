package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 방_배정하기_R2 {
    static boolean[] visited;
    static boolean flag;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            // 방
            Integer A = Integer.parseInt(stringTokenizer.nextToken());
            Integer B = Integer.parseInt(stringTokenizer.nextToken());
            Integer C = Integer.parseInt(stringTokenizer.nextToken());
            int[] arr = new int[]{A,B,C};
            // 인원
            Integer N = Integer.parseInt(stringTokenizer.nextToken());
            // 계산 여부 확인
            visited = new boolean[N +1];

            calc(arr,N,0);
            bw.write( flag ? "1" : "0");

        } catch (Exception e){
            e.printStackTrace();
        } // try - cathc
    }

    public static void calc(int[] arr, int N, int sum){
        if( N < sum) return;
        if(flag || visited[sum]) return;
        if(N == sum) flag = true;
        visited[sum] = true;
        for(int i : arr){
            calc(arr,N , sum + i);
        } // for
    }

}
