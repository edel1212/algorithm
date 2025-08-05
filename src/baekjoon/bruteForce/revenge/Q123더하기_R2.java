package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q123더하기_R2 {
    static int result = 0;
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for( int i = 0 ; i < N ; i++ ){
                arr[i] = Integer.parseInt(br.readLine());
            } // for

            for(int i : arr){
                result = 0;
                dfs(i, 0);
                bw.write(String.valueOf(result));
                bw.newLine();
            } // for

        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static void dfs(int o, int sum){
        if( o < sum) return;
        if(o == sum) {
            result++;
            return;
        } // if
        for(int i = 1 ; i <= 3 ; i++){
            dfs(o, sum + i);
        } // for
    }
}
