package do_it.quiz;

import java.io.*;
import java.util.Arrays;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 삽입 정렬은 1부터 시작 - 0번 Index 부터 비교하기 때문임
        for(int i = 1 ; i < N ; i++){
            // 선택된 값
            int key = arr[i];
            // 정렬된 Index 범위
            int sortRange = i - 1;
            // 정렬된 범위 내 key가 더 작을 경우
            while(0 <= sortRange && key < arr[sortRange]){
                // 해당 Index SortRange shift
                arr[sortRange + 1] = arr[sortRange];
                sortRange--;
            } // while

            // key를 올바른 위치에 삽입 "sortRange" 의 값은 -- 되므로 필요 위치까지 이동 되어있음
            arr[sortRange + 1] = key;

        } // for

        int result = 0;

        // 누적 합
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j <= i ; j ++){
                result += arr[j];
            } // for
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}
