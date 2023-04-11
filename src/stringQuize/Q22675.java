package stringQuize;

import java.io.*;
import java.util.StringTokenizer;

public class Q22675 {
    /**
     * 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 즉,
     * 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
     * S에는 QR Code "alphanumeric" 문자만 들어있다.
     *
     * QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
     * */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 반복 횟수
            int loopCnt = Integer.valueOf(br.readLine());
            for(int i = 0 ; i < loopCnt ; i++){
                StringTokenizer strToken = new StringTokenizer(br.readLine()," ");
                // 반복 횟수
                int R = Integer.valueOf(strToken.nextToken());
                // 반복 대상이 될 문자
                String S = strToken.nextToken();
                // 반환 값
                StringBuilder P = new StringBuilder();
                // 입력받은 문자열만큼 반복
                for(int j = 0 ; j < S.length(); j++){
                    // R번 반복
                    for(int z = 0 ; z < R; z++){
                        P.append(S.charAt(j));
                    }//for
                }//for
                bw.write(String.valueOf(P));
                bw.newLine();
            }//for
            bw.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
