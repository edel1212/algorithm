package do_it.quiz;

import java.io.*;

public class 수_정렬하기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i < N ;  i++) arr[i] = Integer.parseInt(br.readLine());

//        for(int i = 0 ; i < N ; i++){
//            for(int j = 0 ; j < N - i ; j++){
//                int o1 = arr[j];
//                int nextIndex = j + 1;
//                if(N <= nextIndex) break;
//                int o2 = arr[nextIndex];
//
//                int tmp = o2;
//                if(o2 < o1 ){
//                    o2 = o1;
//                    o1 = tmp;
//
//                    // swap
//                    arr[j] = o1;
//                    arr[nextIndex] = o2;
//                } // if
//
//            } // for
//        } // for


        // -1 로 시작하는 이유는 마지막은 +1을 통해 검사하기 때문임
        for(int i = 0 ; i < N - 1 ; i++){
            for(int j = 0 ; j< N - 1 -i ; j++){
                if(arr[j+1] < arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                } // for
            }   //for
        } // for

        for(int i = 0 ; i < N ; i++){
            bw.write(String.valueOf(arr[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
