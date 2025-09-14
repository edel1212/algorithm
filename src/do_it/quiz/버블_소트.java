package do_it.quiz;

import java.io.*;
import java.util.Arrays;

public class 버블_소트 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열의 개수
        int N = Integer.parseInt(br.readLine());
        // 원본 배열 생성
        Foo[] arr = new Foo[N];
        // 배열 초기화
        for(int i = 0 ; i < N ; i++){
            int value = Integer.parseInt(br.readLine());
            arr[i] = new Foo(i, value);
        }// for

        // 정렬 O(nlongn)
        Arrays.sort(arr);

        // 최고 이동 횟수
        int maxMoveCount = Integer.MIN_VALUE;

        for(int i = 0 ; i < N ;i++){
            // 현재 위치에서 얼마나 당겨졌는지, 멀어졌는데 값의 차이를 -i 를 통해 계산함
            maxMoveCount = Math.max(maxMoveCount, arr[i].index - i );
        } // for

        bw.write(String.valueOf(maxMoveCount + 1));
        bw.flush();
        bw.close();
    }


    /**
     * 인덱스 번호와 값을 갖는 class
     */
    public static class Foo implements Comparable<Foo> {
        int index;
        int value;

        public Foo(int index, int value){
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Foo o) {
            // 오름차순 정렬
            return this.value - o.value;
        }

        @Override
        public String toString(){
            return "index : " + this.index + " ___ value : " + this.value;
        }
    }
}
