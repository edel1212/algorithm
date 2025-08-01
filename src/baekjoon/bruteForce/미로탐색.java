package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 미로탐색 {
    public static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            // Row 값
            int N = Integer.parseInt(stringTokenizer.nextToken());
            // Col 값
            int M = Integer.parseInt(stringTokenizer.nextToken());



            bw.write(String.valueOf(minDiff));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
