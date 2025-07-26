package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 모든_순열 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            visited = new boolean[N];
            result = new int[N];
            for(int i = 0; i < N ;i++) arr[i] = i+1;

            dfs(0, bw);
        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static void dfs(int depth, BufferedWriter bw) throws Exception{
        if(depth == N){
            for(int i =0 ; i < result.length; i++) bw.write(result[i] + " ");
            bw.newLine();
        } // for
        for(int i = 0 ; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                // 깊이 == 결과 Index
                result[depth] = arr[i];
                dfs(depth+ 1 , bw);
                visited[i] = false;
            } // if
        } // for
    }
}
