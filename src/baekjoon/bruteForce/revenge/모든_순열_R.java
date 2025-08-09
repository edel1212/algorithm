package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 모든_순열_R {
    static int[] arr;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int N = Integer.parseInt(br.readLine());
            arr= new int[N];
            for(int i = 0 ; i < N ; i++) arr[i] = i + 1;
            boolean[] visited = new boolean[N];
            // 순열
            dfs(visited, new ArrayList<>(), bw);

        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static void dfs(boolean[] visited, List<Integer> tmp, BufferedWriter bw) throws Exception{
        if(tmp.size() == arr.length){
            bw.write(tmp.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            bw.newLine();
            return;
        } // if

        for(int i = 0 ; i < arr.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                tmp.add(arr[i]);
                dfs( visited, tmp, bw);
                tmp.remove(tmp.size()-1);
                visited[i] = false;
            } // if
        } // for

    } // if

}
