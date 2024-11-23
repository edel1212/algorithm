package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q2750 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            for(int i = 0 ; i < N ; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }// loop

            arr = Arrays.stream(arr).sorted().toArray();

            for(int item : arr){
               bw.write(String.valueOf(item));
               bw.newLine();
            }//
            bw.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
