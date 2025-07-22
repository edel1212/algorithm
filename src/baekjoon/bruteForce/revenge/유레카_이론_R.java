package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 유레카_이론_R {
    static List<Integer> triangleList = new ArrayList<>();
    static boolean flag = false;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {

            // 삼각형을 만들 수 있는 수의 개수를 구함 (배열)
            for(int n = 1 ; n*(n+1)/2 <= 1_000; n++){
                triangleList.add( n*(n+1)/2 );
            } // for

            int inputNum = Integer.parseInt(br.readLine());

            for(int i = 0 ; i < inputNum; i++){
                flag = false;
                int targetNum = Integer.parseInt(br.readLine());
                dfs(0,targetNum,0);
                bw.write( flag ? "1":"0" );
                bw.newLine();
            } // for

        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static void dfs(int depth, int base, int sum){
        if(depth == 3){
            if(sum == base)flag = true;
            return;
        } // if
        for(int i = 0 ; i < triangleList.size() ; i++){
            dfs( depth + 1,base, sum + triangleList.get(i));
        } // for
    }
}
