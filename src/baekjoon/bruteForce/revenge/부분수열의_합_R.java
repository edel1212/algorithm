package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 부분수열의_합_R {

    static int N;
    static int S;
    static int[] arr;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            // 수열의 개수
            N = Integer.parseInt(stringTokenizer.nextToken());
            // 대상 값
            S = Integer.parseInt(stringTokenizer.nextToken());
            arr = new int[N];

            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(stringTokenizer.nextToken());

            //S ==0 일 경우가 문제야 무조건 하나는 골라야 해
            int count = dfs(0, 0, 0);
            bw.write(String.valueOf(count));
            bw.flush();
        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static int dfs(int idx, int sum, int selectedCount) {
        // 모든 경우의 수를 확인 했을 경우에만 반환
        if(idx == arr.length){
            boolean isPossible = sum == S && selectedCount > 0 ;
            return isPossible ? 1 : 0;
        } // if

        // 요소를 선택 했을 경우 계산
        int countInclude = dfs(idx + 1, sum + arr[idx], selectedCount + 1);

        // 요소를 선택하지 않았을 경우 계산
        int countExclude = dfs(idx + 1, sum, selectedCount);

        return countInclude + countExclude;
    }

}
