package recursiveFunction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1914 {
    /**
     * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다.
     * 각 원판은 반경이 큰 순서대로 쌓여있다.
     * 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다. ( 1 -> 3 )
     *
     * 1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
     * 2. 쌓아 놓은 원판은 "항상" 위의 것이 아래의 것보다 "작아"야 한다.
     *
     * 이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
     *
     * 입력
     * 첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 100)이 주어진다.
     *
     * 출력
     * 첫째 줄에 옮긴 횟수 K를 출력한다.
     * N이 20 이하인 입력에 대해서는 두 번째 줄부터 수행 과정을 출력한다.
     * 두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데,
     * 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다. N이 20보다 큰 경우에는 과정은 출력할 필요가 없다.
     *
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            /**
             *
             * 하노이 법칙 힌트
             * 1. 항상 패턴은 같다 ( 목포하는 가장 큰 기둥을 C로 이동하기 위해서는 N-1개를 B로 보내야함 )
             *    A -> B  [ f(n-1) ]
             *    A -> C  [ 가장 아래를 옮기는 1번 ]
             *    B -> C  [ f(n-1) ]
             * 
             * 2. 공식으로 변경하면 이동 획수는 총 2의 N 승 -1 이다
             * 
             * 3. 첫 시작 N의 값이 짝 수일 경우 처음 시작은 B, 홀 수일 경우 목적 대상인 C로 이동
             *
             * */

        } catch(Exception e){
            e.printStackTrace();
        }// try catch
    }
}
