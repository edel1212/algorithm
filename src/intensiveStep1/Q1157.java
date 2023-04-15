package intensiveStep1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q1157 {
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

            List<String> orderKey = resultMap.keySet().stream()
                    .sorted(Comparator.comparing(keys-> resultMap.get(keys)).reversed())
                    .collect(Collectors.toList());

            final int MAX = resultMap.values().stream().max(Comparator.comparing(x->x)).get();

            if(orderKey.size() == 1){
                bw.write(String.valueOf(orderKey.get(0)));
            } else {
                if(resultMap.get(orderKey.get(1)) == MAX){
                    bw.write("?");
                } else {
                    bw.write(String.valueOf(orderKey.get(0)));
                }
            }
            bw.flush();
        } catch(IOException io) {
            io.printStackTrace();
        }
    }
}
