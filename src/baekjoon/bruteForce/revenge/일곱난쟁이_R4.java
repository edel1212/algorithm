package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 일곱난쟁이_R4 {
    static List<Integer> correctDwarf = new ArrayList<>();
    static int[] input = new int[9] ;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            for(int i = 0; i < 9 ; i++){
                input[i] = Integer.parseInt(br.readLine());
            } // for

            dfs(0,0,0,new ArrayList<>());

            Collections.sort(correctDwarf);
            for(int dwarf : correctDwarf){
                bw.write(String.valueOf(dwarf));
                bw.newLine();
            }// for
        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }


    public static void dfs(int depth, int idx, int sum , List<Integer> tmp){
        if(!correctDwarf.isEmpty()) return;
        if(depth == 7){
            if(sum == 100) correctDwarf = new ArrayList<>(tmp);
            return;
        } // if

        for(int i = idx ; i < input.length; i++){
            tmp.add(input[i]);
            dfs(depth + 1, i + 1, sum + input[i], tmp);
            tmp.remove(tmp.size() - 1);
        } // for
    }

}
