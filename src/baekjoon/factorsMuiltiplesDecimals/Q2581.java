package baekjoon.factorsMuiltiplesDecimals;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q2581 {
    /**
     * 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
     *
     * 예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로,
     * 이들 소수의 합은 620이고, 최솟값은 61이 된다.
     * */
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int min = Integer.valueOf(br.readLine());
            int max = Integer.valueOf(br.readLine());

            // 소수를 담을 List
            List<Integer> decimalArr = new ArrayList<>();

            // min ~ max까지의 값
            for(int i = min; i <= max ; i++){
                List<Integer> tmpArr = new ArrayList<>();
                // 초소값 확인
                for(int k = 1 ; k <= i ; k++){
                    if(i%k != 0) continue;
                    tmpArr.add(k);
                }//for
                // 소수만 걸러냄
                if(tmpArr.size() == 2) decimalArr.add(i);
            }//for

            if(decimalArr.size() == 0){
                bw.write("-1");
            } else{
                bw.write(String.valueOf(decimalArr.stream().reduce((i,j)->i+j).get()));
                bw.newLine();
                bw.write(String.valueOf(decimalArr.stream().min(Comparator.comparing(o->o)).get()));
            }
            bw.flush();

        }catch(IOException io){
            io.printStackTrace();
        }

    }
}
