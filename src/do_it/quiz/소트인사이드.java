package do_it.quiz;

import java.io.*;

public class 소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int[] arr = new int[line.length()];
        // init
        for (int i = 0; i < line.length(); i++){
            arr[i] = line.charAt(i) - '0';
        } // for

        for(int i = 0 ; i < arr.length; i++){
            int maxIdx = i;
            for(int j = i + 1 ; j < arr.length; j++){
                // 가장 큰 값의 Index를 구함
                if(arr[maxIdx] < arr[j]){
                    maxIdx = j;
                } // if
            }// for

            // 왼쪽 값과 가장 큰 값 비교
            if(arr[i] < arr[maxIdx]){
                int tmp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = tmp;
            } // if

        }// for

        for(int i : arr){
            bw.write(String.valueOf(i));
        } // for
        bw.flush();
        bw.close();
    }

}
