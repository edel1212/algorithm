package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 방_배정하기_R {
    static int N;
    static boolean[] visited;
    static boolean flag = false;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());
            int C = Integer.parseInt(stringTokenizer.nextToken());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            visited = new boolean[N +1];
            int[] rooms = new int[3];
            rooms[0] = A;
            rooms[1] = B;
            rooms[2] = C;
            dfs(rooms, 0);
            bw.write( flag ? "1" : "0" );
        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static void dfs(int[] rooms, int sum){
        if(N < sum || visited[sum]) return;
        if(sum == N){
            flag = true;
            return;
        } // if
        visited[sum] = true;
        for(int room : rooms){
            dfs(rooms, sum + room);
        } // for
    }
}
