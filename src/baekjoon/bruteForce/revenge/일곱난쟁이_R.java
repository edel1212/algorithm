package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 일곱난쟁이_R {

    // 조합을 사용해서 구해야하는 문제
    static List<Integer> correctDwarfs = new ArrayList<>();
    static int[] dwarfs = new int[9];
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            for(int i = 0 ; i < 9 ; i++) dwarfs[i] = Integer.parseInt(br.readLine());
            dfs(0,0,0,new ArrayList<>());
            for(int item :  correctDwarfs){
                bw.write(String.valueOf(item));
                bw.newLine();
            } //
        } catch(Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static void dfs(int depth, int start, int sum, List<Integer> tmp){
        // 7번 서치 했을 경우
        if( 7 == depth){
            // 합의 수가 100일 경우 정답 드뤄프 목록에 추가
            if( sum == 100 ) correctDwarfs = new ArrayList<>(tmp);
            return;
        } // if
        // d
        for(int i = start; i < dwarfs.length; i++){
            tmp.add(dwarfs[i]);
            dfs(depth + 1, i + 1, sum + dwarfs[i], tmp );
            tmp.remove( tmp.size() - 1 );
        } // for
    }
}
