package do_it.quiz;

import java.io.*;
import java.util.Arrays;

public class 잃어버린_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // - 기준으로 스플릿
        String[] str = br.readLine().split("-");

        int answer = 0;

        for(int i = 0 ; i < str.length ; i++){
            int tmp = getSum(str[i]);
            // 첫 값은 더함 - 전제 조건 처음과 마지막은 숫자임을 활용
            if(i == 0){
                answer += tmp;
            } else {
                // 나머지는 빼줌 "-" 로 스플릿 했기에 뒤에 나오는 나머지 배열은 다 뺄 값임
                answer -= tmp;
            } // if - else

        } // for

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static int getSum(String a){
        String[] S = a.split("\\+");
        return Arrays.stream(S)
                .mapToInt(Integer::parseInt)
                .reduce((o1,o2)->o1+o2)
                .getAsInt();
    }

}
