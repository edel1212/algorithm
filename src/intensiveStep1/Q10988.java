package intensiveStep1;

import java.io.*;

public class Q10988 {
    /**
     * 알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.
     *
     * 팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다.
     *
     * level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            String param = br.readLine();

            StringBuilder compareStr = new StringBuilder();

            for(int i = param.length() -1 ; i >= 0; i--){
                compareStr.append(param.charAt(i));
            }//for

            /** ⭐️ 새로운 지식 !
             *  String result = param.equals(compareStr) ? "1" : "0";
             *  💬 해당 코드의 equals() 결과가 같은 문자여도 false를 반환 하는 이유
             *
             *  이유
             *  - Java의 String 클래스와 , StringBuilder 클래스는 다른 방식으로 문자열을 다룬다.
             *     - String : 불변
             *     - StringBuilder, StringBuffer : 가변
             *  - String Class의 경우 문자열 리터럴 풀에 저장된다.
             *     - 문자열 상수풀에서는 동일한 문자열이 존재할경우 새로운 문자열을 생성하지 않고 관리해 준다.
             *  - StringBuilder, StringBuffer의 경우 가변이기에 문자열 리터럴 풀에 들어가지 않는다.
             * */

            String result = param.equals(compareStr.toString()) ? "1" : "0";

            bw.write(result);
            bw.flush();
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
