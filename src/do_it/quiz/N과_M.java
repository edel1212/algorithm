package do_it.quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N과_M {
    static BufferedWriter bw;
    static boolean[] visited;
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        // 수열의 범위
        N = Integer.parseInt(tokenizer.nextToken());
        // 원하는 수열의 개수
        M = Integer.parseInt(tokenizer.nextToken());

        int[] arr = new int[N + 1];
        for(int i = 1 ; i <= N ; i++) arr[i] = i;

        visited = new boolean[N + 1];
        dfs(0, new ArrayList<>());

        bw.flush();
        bw.close();
    }

    public static void dfs(int depth, List<Integer> tmp) throws IOException{
        if(tmp.size() == M){
            for(int i : tmp){
                bw.write(i + " ");
            } // for
            bw.newLine();
            return;
        } // if

        for(int i = 1 ; i <= N ;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp.add(i);
                dfs(depth + 1, tmp);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            } // if
        } // for

    }

}
