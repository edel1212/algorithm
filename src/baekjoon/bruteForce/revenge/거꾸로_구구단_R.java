package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 거꾸로_구구단_R {
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            List<Integer> list = new ArrayList<>();
            for(int i = 1; i<= M ; i++){
                list.add( N * i );
            } //for

            Integer result = list.stream().map(i -> new StringBuilder().append(i).reverse())
                    .map(i -> Integer.parseInt(i.toString()))
                    .sorted(Comparator.reverseOrder())
                    .findFirst().get();
            bw.write(String.valueOf(result));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
