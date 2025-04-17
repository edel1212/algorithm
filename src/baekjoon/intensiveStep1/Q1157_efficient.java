package baekjoon.intensiveStep1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Q1157_efficient {
    /**
     * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
     * 단, 대문자와 소문자를 구분하지 않는다.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 문자열을 입력받는다 - 대소문자를 구분하지 않으니 대문자로 변경
            String param = br.readLine().toUpperCase();

            // 각각의 단어와 개수를 담을 Map
            Map<String, Integer> resultMap = new HashMap<>();
            // 배열에 문자 주입
            for(char item : param.toCharArray()){
                String parseStr = Character.toString(item);
                if(!resultMap.containsKey(parseStr)){
                    resultMap.put(parseStr , 1);
                    continue;
                }// if
                resultMap.put(parseStr , resultMap.get(parseStr) + 1);
            }

            // 반환할 값
            String result   = "";
            // 최대 번호 수
            int maxNum      = 0;
            for(String key : resultMap.keySet()){
                // 각 키의 Value를 받아옴
                int count = resultMap.get(key);

                if(count > maxNum){                 // Max 보다 클 경우 값 변경
                    result = key;
                    maxNum = resultMap.get(key);
                } else if(count == maxNum){        // Max 와 같을 경우
                    result = "?";
                } // if - else-if
            }// for

            bw.write(result);
            bw.flush();
        } catch(IOException io) {
            io.printStackTrace();
        }
    }
}