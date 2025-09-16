package do_it.quiz.revange;

import java.io.*;
import java.util.Arrays;

public class 버블소트_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 현재 문제의 풀의 실마리는 1차 졍렬 이후 기존 배열에서 가장 많이 이동한 위치를 확인 후 +1을 해줘서 반환해주는 것이다.

        int N = Integer.parseInt(br.readLine());
        IndexOfValue[] arr = new IndexOfValue[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = new IndexOfValue(i, Integer.parseInt(br.readLine()));
        } // for

        Arrays.sort(arr);

        int maxCount = Integer.MIN_VALUE;

        for(int i = 0 ; i < N ; i++){
            int idxCount = arr[i].index - i;
            maxCount = Math.max(maxCount, idxCount);
        } // for


        bw.write(String.valueOf(maxCount + 1));
        bw.flush();
        bw.close();
    }


    public static class IndexOfValue implements Comparable<IndexOfValue> {
        int index;
        int value;

        public IndexOfValue(int index, int value){
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(IndexOfValue o) {
            return this.value - o.value;
        }
    }
}
