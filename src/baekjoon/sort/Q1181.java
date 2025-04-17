package baekjoon.sort;

import java.io.*;
import java.util.Arrays;

public class Q1181 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int N = Integer.parseInt(br.readLine());

            String[] arr = new String[N];
            for(int i = 0 ; i < N ; i++){
                arr[i] = br.readLine();
            }// for

            Arrays.stream(arr).sorted()
                    .distinct()
                    .sorted((c1,c2) -> Integer.compare(c1.length(), c2.length()))
                    .forEach(item-> {
                        try {
                            bw.write(item);
                            bw.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
            bw.flush();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
