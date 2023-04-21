package twoDimensArr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q10798_Fail {
    /**
     * 한 줄의 단어는 글자들을 빈칸 없이 연속으로 나열해서 최대 15개의 글자들로 이루어진다.
     * 또한 만들어진 다섯 개의 단어들의 글자 개수는 서로 다를 수 있다.
     *
     * 심심해진 영석이는 칠판에 만들어진 다섯 개의 단어를 세로로 읽으려 한다. 세로로 읽을 때,
     * 각 단어의 첫 번째 글자들을 위에서 아래로 세로로 읽는다. 다음에 두 번째 글자들을 세로로 읽는다.
     * 이런 식으로 왼쪽에서 오른쪽으로 한 자리씩 이동 하면서 동일한 자리의 글자들을 세로로 읽어 나간다.
     * 위의 그림 1의 다섯 번째 자리를 보면 두 번째 줄의 다섯 번째 자리의 글자는 없다.
     * 이런 경우처럼 세로로 읽을 때 해당 자리의 글자가 없으면, 읽지 않고 그 다음 글자를 계속 읽는다.
     * 그림 1의 다섯 번째 자리를 세로로 읽으면 D1gk로 읽는다.
     *
     * 그림 1에서 영석이가 세로로 읽은 순서대로 글자들을 공백 없이 출력하면 다음과 같다:
     *
     * Aa0aPAf985Bz1EhCz2W3D1gkD6x
     *
     * 칠판에 붙여진 단어들이 주어질 때, 영석이가 세로로 읽은 순서대로 글자들을 출력하는 프로그램을 작성하시오.
     *
     * 총 다섯줄의 입력이 주어진다. 각 줄에는 최소 1개, 최대 15개의 글자들이 빈칸 없이 연속으로 주어진다.
     * 주어지는 글자는 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’ 중 하나이다. 각 줄의 시작과 마지막에 빈칸은 없다.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            List<String> tmpArr = new ArrayList<>();
            for(int i = 0 ; i < 5 ; i++){
                String word = br.readLine();
                tmpArr.add(word);
            }//for

            StringBuilder result = new StringBuilder();

            int size = tmpArr.size();

            // 새로로 변환
            while(size > 0){
                for(int idx = 0 ; idx < tmpArr.size() ; idx++){

                    if(tmpArr.get(idx).length() > 0){ // 단어가 있을 경우
                        if(tmpArr.get(idx).charAt(0) != ' '){
                            // 첫번째 단어 추가
                            result.append(tmpArr.get(idx).charAt(0));
                        }
                        // substring()을 이용하여 첫번째 삭제
                        tmpArr.set(idx,tmpArr.get(idx).substring(1,tmpArr.get(idx).length()));
                    } else {                        // 단어가 없을 경우
                        size--;
                    }// if - else
                }//for
            }// while

            bw.write(result.toString().trim());
            bw.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
