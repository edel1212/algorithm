package intensiveStep1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q25206 {
    /**
     * 인하대학교 컴퓨터공학과를 졸업하기 위해서는, 전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다.
     * 그런데 아뿔싸, 치훈이는 깜빡하고 졸업고사를 응시하지 않았다는 사실을 깨달았다!
     *
     * 치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.
     *
     * 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
     *
     * 인하대학교 컴퓨터공학과의 등급에 따른 과목평점은 다음 표와 같다.
     *
     * A+	4.5
     * A0	4.0
     * B+	3.5
     * B0	3.0
     * C+	2.5
     * C0	2.0
     * D+	1.5
     * D0	1.0
     * F	0.0
     *
     * P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.
     *
     * 과연 치훈이는 무사히 졸업할 수 있을까?
     *
     * */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 반복 횟수 20번
            final int LOOP_CNT = 20;

            // 등급별 학점
            Map<String, Double> gradeMap = new HashMap<>();
            gradeMap.put("A+" , 4.5);
            gradeMap.put("A0" , 4.0);
            gradeMap.put("B+" , 3.5);
            gradeMap.put("B0" , 3.0);
            gradeMap.put("C+" , 2.5);
            gradeMap.put("C0" , 2.0);
            gradeMap.put("D+" , 1.5);
            gradeMap.put("D0" , 1.0);
            gradeMap.put("F"  , 0.0);
            gradeMap.put("P"  , 0.0);

            Double result = 0.0;
            Double sumCredit = 0.0;

            for(int i = 0 ; i < LOOP_CNT ; i++){
                // 입력받은 값 과목 학점 등급 공백 기준으로 나눔
                StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");

                //과목명은 불필요하므로 스킵
                String subject = strToken.nextToken();

                // 기본 베이스 학점
                Double baseCredit = Double.valueOf(strToken.nextToken());

                String gradeStr = strToken.nextToken();
                // 내가 받은 학점
                Double myCredit = gradeMap.get(gradeStr);

                if("P".equals(gradeStr)) continue;

                sumCredit += baseCredit;

                result += baseCredit * myCredit;

            }//for

            double divisionResult = result / sumCredit;
            bw.write(String.valueOf( (double)((int) (divisionResult * 1_000_000))/1_000_000 ));
            bw.flush();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}