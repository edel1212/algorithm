package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 순열_조합_개인_테스트 {
    static int[] arr;
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            for( int i = 0; i < N ; i++ ) arr[i] = i+1;
            boolean[] visited = new boolean[N];
            // 순열 - 순서 중요함 각각의 값이 같아도 순서가 다르면 다른 값
            dfs1(visited, new ArrayList<>());

            System.out.println("-----------------------");
            // 조합 - 순서 X 같은 값이 들어있으면 그건 값이야
            dfs2(0, new ArrayList<>());

        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    // 순열
    public static void dfs1(boolean[] visited, List<Integer> tmp){
        if(tmp.size() == 2){
            System.out.println(tmp.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        } // if

        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                tmp.add(arr[i]);
                dfs1(visited, tmp);
                visited[i] = false;
                tmp.remove( tmp.size() - 1 );
            } // if
        } // for

    }

    // 조합
    public static void dfs2(int idx, List<Integer> tmp){
        if(tmp.size() == 2){
            System.out.println(tmp.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        } // if

        for(int i = idx; i < arr.length; i++){
            tmp.add(arr[i]);
            dfs2(i  + 1, tmp);
            tmp.remove( tmp.size() - 1 );
        } // for

    }
}
