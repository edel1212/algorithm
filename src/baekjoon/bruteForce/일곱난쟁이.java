package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 일곱난쟁이 {
    // 아홉명의 난쟁이기에 사이즈 지정
    static int[] input = new int[9];
     static List<Integer> dwarfList = new ArrayList<>();
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            for(int i = 0 ; i < 9 ; i++)  input[i] = Integer.parseInt(br.readLine());

            dfs(0,0,0,  new ArrayList<>());

            dwarfList.sort(Comparator.naturalOrder());
            for(Integer dwarf : dwarfList){
                bw.write(String.valueOf(dwarf));
                bw.newLine();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    // int depth : 깊이, int start 탐지를 할 index, int 합친 가격, list
    public static void dfs(int depth, int start, int sum, List<Integer> tmp){
        if(depth == 7){
            if(sum == 100){
                dwarfList = new ArrayList<>(tmp);
                return;
            } // if
            return;
        } // if
        for(int i = start; i < input.length ; i++){
            tmp.add(input[i]);
            dfs(depth + 1, i + 1, sum + input[i], tmp);
            tmp.remove(tmp.size() - 1);
        } // for
    }

}
