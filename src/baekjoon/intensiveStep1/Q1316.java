package baekjoon.intensiveStep1;

import java.io.*;

public class Q1316 {
    /**
     * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
     * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
     * aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
     *
     * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
     *
     * 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다.
     * 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)) ){

            // 입려 받을 단어 개수
            int loopCnt = Integer.valueOf(br.readLine());

            // 반환 Count
            int result = 0;

            // 반복
            for(int i = 0 ; i < loopCnt ; i++){

                // 중복 제거 문자열 생성
                StringBuilder tmp = new StringBuilder();
                // 반복 있을경우 False로 변경
                boolean flag = true;
                // 단어의 알파벳 개수만 큼 반복
                String word = br.readLine();

                for(int c = 0; c < word.length(); c ++){
                    if(tmp.length() > 0 && tmp.charAt(tmp.length()-1) == word.charAt(c)){
                        continue;
                    }
                    if(tmp.toString().contains(Character.toString(word.charAt(c)))){
                        flag = false;
                        break;
                    }
                    tmp.append(word.charAt(c));
                }//for
                if(flag){
                    result++;
                }// if
            }//for

            bw.write(String.valueOf(result));
            bw.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
