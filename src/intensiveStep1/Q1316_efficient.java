package intensiveStep1;

import java.io.*;

public class Q1316_efficient {
    /**
     * 그룹 단어
     * 내가 이해하고 풀이한 방식 👎
     * - 1 . 단어를 받는다
     *   2 . 단어의 알파벳의 앞자리와 다음자리를 비교하여 같지 않으면 새로운 문자열로 생성
     *   3 . 반복
     *   4 . 앞단어가 아님 그 전에 단어 contains()를 사용하여 있을 경우 Loop 종료
     *   5 . 만들어놓은 boolean 를 이용하여 break에 접근 하지 않은 경우만 Result++
     *
     * 개선된 방식 👍
     *  - 사실 이해한 로직은 나와 같으나 풀이방식에서 불필요한 문자열을 생성하지 않음
     *  - 1 . 알파벳 단어 개수만큼의 알파벳순서의 boolean배열을 생성
     *    2 . 받아온 단어의 알파벳 개수만큼 반복
     *    3 . alphaChkArr[c - 'a']) ----> 'a'를 해줌으로서 인덱스번호를 구할수 있음
     *    4 . 조건문 : 처음 접근일 경우 해당 알파벳배열을 true로 변경
     *    5 . 그외 경우 :
     *            안의 조건문 : 연속된 알파벳이 아닌 경우(word.charAt(j - 1) != c)
     *                       그룹단어 체크를 false로 변경 반복문 강제 종료
     *    7 . 그룹단어 체크가 True일 경우 결과값 ++
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int loopCnt = Integer.valueOf(br.readLine());

            int result = 0;

            for(int i = 0 ; i < loopCnt ; i++){

                // 입력받은 단어
                String word = br.readLine();
                // 앒파벳 단어 개수 26개를 체크한 배열
                boolean[] alphaChkArr = new boolean[26];
                // 그룹 단어인지 체크
                boolean isGroupWord = true;

                /**
                 * 👉 여기서부터 로직이 달라짐
                 * */
                for (int j = 0; j < word.length(); j++) {

                    // 단어의 알파벳
                    char c = word.charAt(j);

                    /**
                     * 💬 java에서 char는 내부적으로 아스키
                     *    코드 값을 갖는다 따라사 [ 타겟인덱스 - 'a'] 를 해줌으로써
                     *    해당 알파벳이 처음 등장하는 것을 체크함
                     * */
                    if (!alphaChkArr[c - 'a']) {
                        // 체크가 완료 되었으니 true
                        alphaChkArr[c - 'a'] = true;
                    } else {  // 💬 해당 알파벳이 이미 등장했던 경우

                        /**
                         * 앞의 단어를 가져온 후
                         * 연속 된 단어가 아니면 loop 종료와
                         * isGroupWord를 False로 변경
                         * */
                        if (word.charAt(j - 1) != c) {
                            isGroupWord = false;
                            break;
                        }//if
                    }// if - else
                }//for
                // 그룹 단어라면 개수 증가
                if (isGroupWord) {
                    result++;
                }//if
            }//for

            bw.write(String.valueOf(result));
            bw.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
