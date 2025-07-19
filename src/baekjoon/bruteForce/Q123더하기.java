package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q123더하기 {
    static int[] baseNumbers = {1,2,3};
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int size = Integer.parseInt(br.readLine());
            int[] numbers = new int[size];
            for(int i = 0 ; i < size ; i++) numbers[i] = Integer.parseInt(br.readLine());

            for(int num : numbers){
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
        for(int baseNum : baseNumbers){
            count += dfs(base, sum + baseNum);
        } //for
        return count;
    }
}
