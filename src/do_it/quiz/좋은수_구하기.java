package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋은수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받은 수
        int N = Integer.parseInt(br.readLine());

        // 배열 선언 - 값을 더하는 부분이 있기에 overflow를 피하기 위해 long 사용
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // arr init
        for (int i = 0; i < N; i++)  arr[i] = Long.parseLong(st.nextToken());

        // 정렬 (투포인터 필수)
        Arrays.sort(arr);

        // 좋은 수 개수
        int count = 0;

        // 값의 범위 loop - 하나하나 대상을 지정하기 위함
        for (int i = 0; i < N; i++) {
            // 비교 대상
            long target = arr[i];
            // 포인터 ( 양끝 쪽을 향함 - 모든 수를 볼 거기 때문 )
            int left = 0;
            int right = N - 1;

            // 값이 겹치지 않을 때까지 loop
            while (left < right) {
                // 더한 값
                long sum = arr[left] + arr[right];

                if (sum == target) {
                    // ✅ 자기 자신을 제외해야 함 - [ 해당 부분을 사용해서 자기 자신을 제외 시킴 ]
                    if (left != i && right != i) {
                        count++;
                        break; // target은 "좋다"임 → 다른 조합 찾을 필요 없음
                    } // if

                    // ⭐️ 자기 자신은 제외 되어야하기에 꼭 필요한 로직
                    if (left == i){
                        left++;
                    } else if(right == i){
                        right--;
                    } // if - else if

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                } // if - else
            } // while

        }// for

        System.out.println(count);
    }
}
