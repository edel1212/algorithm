package sort;

import java.io.*;
import java.util.*;

public class Q10814 {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Object[][] arr = new Object[N][2];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(stringTokenizer.nextToken());
            String name = stringTokenizer.nextToken();
            arr[i][0] = age;
            arr[i][1] = name;
        }// for

        Arrays.asList(arr).stream().sorted( (r1,r2) -> Integer.compare((Integer) r1[0], (Integer) r2[0]))
                .forEach(k-> {
                    try {
                        bw.write( k[0] + " " + k[1] );
                        bw.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        bw.flush();
        bw.close();

    }
}
