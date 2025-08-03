package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 유레카_이론_R3 {
    static boolean flag = false;
    static List<Integer> triangleList = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            for(int i = 1 ; i*(i+1)/2 <= 1_000 ; i++) triangleList.add(i*(i+1)/2);

            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            for(int i = 0; i < N ; i++) arr[i] = Integer.parseInt(br.readLine());

            for(int i = 0; i < arr.length ; i++){
                flag = false;
                dfs(0,0, arr[i]);
                bw.write( flag ? "1" : "0" );
                bw.newLine();
            } // for

        } catch (Exception e){
            e.printStackTrace();
        } //try catch
    }

    public static void dfs(int depth, int sum, int target){
        if(flag) return;
        if(depth == 3){
            if( sum == target ) flag = true;
            return;
        } // if
        for(int t : triangleList){
            dfs(depth + 1, sum + t , target );
        } // for
    }
}
