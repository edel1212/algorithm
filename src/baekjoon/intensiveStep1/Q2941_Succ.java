package baekjoon.intensiveStep1;

import java.io.*;
import java.util.List;

public class Q2941_Succ {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 입력 받은 값
            String word = br.readLine();

            // 반환할 알파겟 개수
            int alphaCnt = countCroatianAlphabet(word);

            // 출럭
            bw.write(String.valueOf(alphaCnt));
            bw.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public static int countCroatianAlphabet(String word) {
        // 기준이 될 변환 단어 목록
        List<String> croatianAlphabets = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

        // 알파벳 개수 카운트
        int alphaCnt = 0;
        // Loop의 기준
        int i        = 0;

        /**
         *
         * 아래의 조건으로 구현할 수있었던 이유는
         * 크로티아 알파벳의 변경 기준이었던 알파벳이
         * 최소 2자리, 최대 3자리 였기 때문에 아래 와같은 조건으로 구현이 가능했다.
         *
         * 1 . 기준점(i) + N && 입력받은 문자열의 substring(기준점 ~ 기준점 + N) 가 존재하는지 확인
         * 2 . 조건에 맞는다면 count++ , i + N [ substring으로 확인했으니 그만큼 더해준다.]
         * 3 . 조건애 맞지 않는 단어일 경우 else를 타 i++를 시켜 문자의 길이와 확인하여 Loop 종료
         *
         * 💬 주의 사항 - substring() 자릿수 확인!!
         *     String word = "nljj";
         *     System.out.println(word.substring(0 , 1)); //n
         *     System.out.println(word.substring(0 , 2)); //nl
         * */
        while (i < word.length()) {
            if (i + 1 < word.length() && croatianAlphabets.contains(word.substring(i, i + 2)) ) {
                alphaCnt++;
                i += 2;
            } else if (i + 2 < word.length() && croatianAlphabets.contains(word.substring(i, i + 3))) {
                alphaCnt++;
                i += 3;
            } else {
                alphaCnt++;
                i++;
            }
        }
        return alphaCnt;
    }
}
