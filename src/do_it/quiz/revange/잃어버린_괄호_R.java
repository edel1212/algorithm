package do_it.quiz.revange;

import java.io.*;
import java.util.Arrays;

public class 잃어버린_괄호_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 해당 문제를 분석해보면 양수를 괄호쳐서 더해주는게 목적임을 알 수 있기에 음수를 기준으로 잘라줌
        String[] str = br.readLine().split("-");

        int result = 0;

        for(int i = 0 ; i < str.length ; i++){
            // 양수일 경우 덧셈을 진행하기 위해 잘라 줌
            String[] S = str[i].split("\\+");

            // 양수일 경우 2개 이상으로 짤라지기에 더 해지고 음수일 경우 1개이기에 더해지지 않음
            int sum = Arrays.stream(S)
                    .mapToInt(Integer::parseInt)
                    .reduce((o1,o2)->o1+o2)
                    .getAsInt();

            // 첫 값은 더함 - 전제 조건 처음과 마지막은 숫자임을 활용
            if(i == 0){
                result += sum;
            } else {
                // 나머지는 빼줌 "-" 로 스플릿 했기에 뒤에 나오는 나머지 배열은 다 뺄 값임
                result -= sum;
            } // if - else

        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

}
