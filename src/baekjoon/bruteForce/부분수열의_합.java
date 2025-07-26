package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 부분수열의_합 {
    static int[] arr;
    static int count;
    static int S;
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(stringTokenizer.nextToken());
            S = Integer.parseInt(stringTokenizer.nextToken());
            // arr init
            arr = new int[N];
            String[] arrStr = br.readLine().split(" ");
            for(int i = 0; i < arrStr.length ; i++) arr[i] = Integer.parseInt(String.valueOf(arrStr[i]));


            bw.write(String.valueOf(dfs(0,0)));
        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static int dfs(int idx, int sum) {
        if (idx == arr.length) { // 모든 경우의 수를 파악하기 위한 기저 조건 없을 경우 모든 경우의 수를 파악하지 못함
            // 공집합은 제외해야 하므로 합이 S이면서 선택한게(count) 있을 때만 1 반환
            return sum == S && count > 0 ? 1 : 0;
        }

        int countInclude;
        int countExclude;

        count++;  // 요소 선택
        // 요소를 포함할 경우 dfs
        countInclude = dfs(idx + 1, sum + arr[idx]);
        count--;  // 요소 선택 취소 (백트래킹)
        // 요소를 포함하지 않을 경우 경우 dfs( idx 카운팅만 함)
        countExclude = dfs(idx + 1, sum); // 요소 미선택

        return countInclude + countExclude;
    }
}
