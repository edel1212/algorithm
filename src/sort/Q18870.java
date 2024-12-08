package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Q18870 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

            for (int i = 0 ; i < N ; i ++) arr[i] = Integer.parseInt(stringTokenizer.nextToken());

            int[]  sortArr = Arrays.stream(arr).distinct().sorted().toArray();

            Map<Integer, Integer> coordMap = new HashMap<>();
            for (int idx = 0 ; idx < sortArr.length ; idx++) coordMap.put(sortArr[idx], idx);

            StringBuilder stringBuilder = new StringBuilder();
            for(int item : arr){
                stringBuilder.append(coordMap.get(item));
                stringBuilder.append(" ");
            }// for
            bw.write(stringBuilder.toString());
            bw.flush();

        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
