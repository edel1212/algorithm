package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 일곱난쟁이_R3 {
    static List<Integer> correct = new ArrayList<>();
    static int[] in;
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            in = new int[9];
            for(int i = 0 ; i < 9; i++) in[i] = Integer.parseInt(br.readLine());

            dfs(0,0,0,new ArrayList<>());
            Collections.sort(correct);
            for(int i : correct){
                bw.write(String.valueOf(i));
                bw.newLine();
            } // for
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dfs(int depth, int start , int sum, List<Integer> tmp){
        if(depth == 7){
            if(sum == 100) correct = new ArrayList<>(tmp);
            return;
        } // if
        for(int i = start ; i < in.length; i++ ){
            tmp.add(in[i]);
            dfs(depth + 1 , i+1, sum + in[i], tmp);
            tmp.remove(tmp.size() - 1);
        }  // for
    }
}
