package do_it.quiz;

import java.io.*;

public class 버블_소트 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 아이디어가 중요한 문제다

        // 수열의 개수가 최대 5,000,000 이기에 일반 버블 정렬로는 풀기 무리
        // 아이디어 : 버블 정렬의 최대 이동 횟수는 1개이다 (반복문이 1칸씩 이동)
        // 일반 정렬을 통해 값을 구하고 해당 값을 통해 정렬전 배열과 index를 비교해서 최대 거리 값 을 찾으면 그게 swap 횟수가 나옴
        // 결과로 +1을 해주는 방식이기에 +1을 해줘서 출력하자
    }
}
