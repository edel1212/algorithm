package baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Q1651 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][2];
            for(int i = 0 ; i < N ; i++){
                StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(tokenizer.nextToken());
                arr[i][1] = Integer.parseInt(tokenizer.nextToken());
            }// for

            List<int[]> result = Arrays.stream(arr).sorted((row1, row2)->{
                if(row1[1] == row2[1]) return Integer.compare(row1[0], row2[0]);
                return Integer.compare(row1[1], row2[1]);
            }).collect(Collectors.toList());

            for(int[] i : result){
                bw.write(i[0]+ " " + i[1]);
                bw.newLine();
            }//for
            bw.flush();

        } catch (Exception e){
            e.printStackTrace();;
        }
    }

}
