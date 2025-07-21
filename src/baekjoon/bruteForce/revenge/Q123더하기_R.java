package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q123더하기_R {
    static int[] baseNumList = {1, 2, 3};
    public static void main(String[] args) {
        try( BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out ));
            BufferedReader br = new BufferedReader ( new InputStreamReader(System.in)  ) ){

            int n = Integer.parseInt(br.readLine());

            int[] targetNum = new int[n];
            for(int i = 0; i < n; i++) targetNum[i] = Integer.parseInt(br.readLine());

            for(int num : targetNum){
                bw.write(String.valueOf(dfs(num, 0)));
                bw.newLine();
            } // for

        } catch (Exception e){
            e.printStackTrace();
        } // try - catch

    }

    public static int dfs(int base, int sum){
        if(base < sum) return 0;      // 초과: 경로 무효
        if(base == sum) return 1;     // 정확히 맞음: 유효한 1가지 경우
        int count = 0;
        for(int baseNum : baseNumList){
            count += dfs(base, sum + baseNum);
        } //for
        return count;
    }

}
