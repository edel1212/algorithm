package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 제곱_ㄴㄴ_수 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 입력 값이 10^12까지 이므로 long 사용
        long min = Long.parseLong(stringTokenizer.nextToken());
        long max = Long.parseLong(stringTokenizer.nextToken());

        // 제곱수의 배수인지'를 체크 - 실제 탐색 해야하는 배열 (최대 1,000,000개)
        boolean[] isNotSquareFree = new boolean[ (int) (max - min + 1) ];

        // 2부터 시작하여 제곱 수를 찾아 나감 (max를 넘는 수는 필요가 없기에 범위 제한)
        // 문제에서 1보다 큰 제곱수를 사용해서 "제곱 ㄴㄴ 수"를 찾으라 함
        for(long i = 2; i * i <= max; i++ ){
            // 제곱수
            long square = i * i;

            // 제곱수에 무엇을 곱해야 처음으로 min을 넘는지 찾을 수
            long start = min / square;
            // 나누어 떨어지지 않을 경우 해당 값은 min보다 작은 값이므로 ++ 해주는 것이다.
            // -> 우리가 찾는 start는 min보다 **크거나 같기 때문**임
            if(min % square != 0){
                start++;
            } // if

            // 범위 내의 값을 곱해가며 찾아감
            for(long j = start ; square * j <= max ;j++){
                // 실제 모든 배열을 만든게 아닌 필요한 부분만 만들었기에 (상대 주소)
                // 제곱근 값에서 min 값을 빼주면 상대 주소가 나온다.
                isNotSquareFree[ (int) (square * j - min) ] = true;
            } // for

        } // for

        int count = 0;
        for(int i = 0 ; i <= max - min; i++){
            if (!isNotSquareFree[i]) {
                count++;
            } // if
        } // for

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
