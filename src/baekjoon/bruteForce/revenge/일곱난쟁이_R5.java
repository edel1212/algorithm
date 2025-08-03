package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 일곱난쟁이_R5 {
    static List<Integer> answer;
    static int[] dwarfList = new int[9];
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            for(int i = 0 ; i < 9 ; i++) dwarfList[i] = Integer.parseInt(br.readLine());

            dfs(0,0,0,new ArrayList<>());

            Collections.sort(answer);
            for(int i : answer){
                bw.write(String.valueOf(i));
                bw.newLine();
            } // for
        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }


    public static void dfs(int depth, int idx, int sum, List<Integer> tmp){
        if(depth == 7){
            if(sum == 100) answer = new ArrayList<>(tmp);
            return;
        } // if
        for(int i = idx ; i < dwarfList.length; i++){
            tmp.add(dwarfList[i]);
            dfs(depth + 1, i + 1, sum + dwarfList[i], tmp );
            tmp.remove(tmp.size() - 1);
        } //for
    }

}
