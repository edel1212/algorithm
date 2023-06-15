package timeComplexity;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Q24262 {
    /**
     * 오늘도 서준이는 알고리즘의 수행시간 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
     *
     * 입력의 크기 n이 주어지면 MenOfPassion 알고리즘 수행 시간을 예제 출력과 같은 방식으로 출력해보자.
     *
     * MenOfPassion 알고리즘은 다음과 같다.
     *
     * MenOfPassion(A[], n) {
     *     i = ⌊n / 2⌋;
     *     return A[i]; # 코드1
     * }
     * */
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            bw.write(String.valueOf(1));
            bw.newLine();
            bw.write(String.valueOf(0));
            bw.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
