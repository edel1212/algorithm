package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 유레카_이론 {

    static List<Integer> triangleNums = new ArrayList<>();
    static boolean answer;
    public static void main(String[] args){
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            // 미리 삼각수를 계산 ( 입력 제약 조간 내 찾아야 하는 K 값의 범위가 있기 때문 3 ≤ K ≤ 1,000 )
            for (int i = 1; i * (i + 1) / 2 <= 1000; i++) {
                triangleNums.add(i * (i + 1) / 2);
            }

            int count = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < count ; i++){
                // 초기화
                answer = false;
                int target = Integer.parseInt(br.readLine());
                dfs(0, target, 0);
                bw.write(answer ? "1" : "0");
                bw.newLine();
            } // for

        } catch (Exception e){
            e.printStackTrace();
        } // try - catch

    }

    public static void dfs(int depth, int target ,int sum){
        if(depth == 3){
            if(sum == target) answer = true;
            return;
        } // if
        for(int i = 0 ; i < triangleNums.size(); i++){
            dfs(depth + 1, target,  sum + triangleNums.get(i));
        } // for
    }

}
