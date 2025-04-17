package baekjoon.factorsMuiltiplesDecimals;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q9506 {
    /**
     * 어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.
     *
     * 예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.
     *
     * n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            while(true){
                // 마지막 수를 제외한 약수를 담을 배열
                List<Integer> tmp = new ArrayList<>();
                Integer n = Integer.valueOf(br.readLine());
                if(n == -1) break;

                // 약수를 tmp 배열에 추가 단 맨 마지막은 제외
                for(int i = 1 ; i < n ; i++){
                    if(n%i !=0) continue;
                    tmp.add(i);
                }//for

                // 더한 값이 같을 경우 True
                int sum = tmp.stream().reduce(0,(i,x)->i+x);

                if( n == sum ){
                    bw.write(n + " = " +tmp.stream().sorted().map(String::valueOf).collect(Collectors.joining(" + ")));
                } else{
                    bw.write(n + " is NOT perfect.");
                }// if - else
                bw.newLine();
            }//while

            bw.flush();
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
