package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 일곱난쟁이_R2 {
    static List<Integer> correctDwarf = new ArrayList<>();
    static int[] inputDwarf;
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            inputDwarf = new int[9];
            for(int i = 0 ; i < 9 ; i ++){
                inputDwarf[i] = Integer.parseInt(br.readLine());
            } // for

            dfs(0,0,0,new ArrayList<>());
            Collections.sort(correctDwarf);
            for(int dwarf : correctDwarf){
                bw.write(String.valueOf(dwarf));
                bw.newLine();
            } // for

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static  void dfs(int depth, int start, int sum , List<Integer> tmp){
        if(!correctDwarf.isEmpty()) return;
        if(depth == 7){
            if(sum == 100) correctDwarf = new ArrayList<>(tmp);
            return;
        } // if
        for(int i = start ; i < inputDwarf.length; i ++){
            tmp.add(inputDwarf[i]);
            dfs(depth + 1, i +1, sum + inputDwarf[i], tmp);
            tmp.remove(tmp.size() - 1);
        } // for
    }
}
