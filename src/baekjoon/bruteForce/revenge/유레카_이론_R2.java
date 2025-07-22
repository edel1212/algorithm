package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 유레카_이론_R2 {
    public static List<Integer> triangleList = new ArrayList<>();
    public static boolean flag;
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // init
            for(int i = 1; i*(i+1)/2 <= 1_000 ; i++ ) triangleList.add(i*(i+1)/2);

            int N = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < N ;i++){
                flag = false;
                int target = Integer.parseInt(br.readLine());
                dfs(0,0,target);
                bw.write( flag ? "1" : "0" );
                bw.newLine();
            } // for

        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static void dfs(int depth, int sum, int base){
        if(depth == 3){
            if(sum == base) flag = true;
            return;
        } // if
        for(int t : triangleList){
            dfs(depth + 1, sum + t, base);
        } // for
    }
}
