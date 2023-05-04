package generalMath1;

import java.io.*;
import java.util.*;

public class Q10757_Fail {
    /**
     * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
     *
     * 첫째 줄에 A와 B가 주어진다. (0 < A,B < 10 ^10000) 만승
     * */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer strToken = new StringTokenizer(br.readLine());

            String A = strToken.nextToken();
            String B = strToken.nextToken();


            StringBuilder result = new StringBuilder("");

            // 1. Long의 최대 범위 2,147,483,647  - maxLength를 10으로 잡자 - 덧셈이 되야하기때문
            // 2. 각각의 A, B를 각 낸후
            // 3 . 같은 자릿수가 맞는 숫자끼리 더함
            // 3 - 1. 더해서 자릿수가 초과할경우 그값을 앞의 수에 추가해줌
            // 4 . 각각의 자릿수가 더해진 값을 문자열로 반환

            List<String> aTmpArr = Q10757_Fail.makeTmpArr(A);
            List<String> bTmpArr = Q10757_Fail.makeTmpArr(B);

            System.out.println(Arrays.toString(aTmpArr.toArray()));
            System.out.println(Arrays.toString(bTmpArr.toArray()));


            List<String> resultArr = new ArrayList<>();

            long tmpA = 0;
            long tmpB = 0;
            long tmpHap = 0;
            for(int i = aTmpArr.size()-1 ; i >= 0 ; i-- ){
                tmpA = Long.valueOf(aTmpArr.get(i)) + tmpHap;
                for(int j = bTmpArr.size()-1 ; j >= 0 ; j-- ){
                    tmpB = Long.valueOf(bTmpArr.get(j));
                    if(i == j){
                        tmpHap = tmpA + tmpB;
                        String parseStr = String.valueOf(tmpHap);
                        if(parseStr.length() > 10){
                            tmpHap = Long.valueOf(parseStr.substring(0,1));
                            resultArr.add(parseStr.substring(1,parseStr.length()));
                        } else{
                            resultArr.add(parseStr);
                        }// if - else
                    }
                }//for
            }//for


            /***
             * 실패이유 : 내가 정한 풀이시간 초과
             *
             * - 1 . 받아온 범위의 숫자를 받아서 자릿수별로 List에 담기 [ 확인 이상없음 ]
             * - 2 . 각 범위의 숫자를 더함 뒷자리부터 했어야했다 .. 실수임 0번쨰 부터 더해야함 [ 문제점 파악했지만 시간 부족.. ]
             * **/

            System.out.println(Arrays.toString(resultArr.toArray()));

            //bw.write(result.toString());
            //bw.flush();

        } catch(IOException io){
            io.printStackTrace();
        }

    }

    /**
     * 받아온 문자열로 10자리 숫자로 잘라 배열에 저장
     * @param numStr
     * @return List<String>
     * */
    private static List<String> makeTmpArr(String numStr){
        List<String> result = new ArrayList<>();

        int tmpCnt = numStr.length();
        while(true){
            if(tmpCnt <= 10){
                result.add(numStr);
                break;
            } else {
                result.add(numStr.substring(numStr.length()-10,numStr.length()));
                tmpCnt -= 10;
                numStr = numStr.substring(0,numStr.length()-10);
            }// if - else
        }// while

        return result;
    }

}
