package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 사탕게임_R {
    static int maxNum = Integer.MIN_VALUE;
    static int inputNum;
    static String[][] box;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            inputNum = Integer.parseInt(br.readLine());
            box = new String[inputNum][inputNum];
            for( int i = 0; i < inputNum; i++ ){
                String line = br.readLine(); // 한 줄을 입력받고
                for (int j = 0; j < inputNum; j++) {
                    box[i][j] = String.valueOf(line.charAt(j));
                }
            } // for


            for( int i = 0; i < inputNum; i++ ){
                for( int j = 0; j < inputNum; j++ ) {
                    if( j + 1 < inputNum ){
                        swap(i,j, i, j+1);
                        checkMax();
                        swap(i,j, i, j+1);
                    } // if

                    if( i + 1 < inputNum ){
                        swap(i,j, i +1, j);
                        checkMax();
                        swap(i,j, i +1, j);
                    } // if
                } // for
            } // for

            bw.write(String.valueOf(maxNum));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void checkMax(){
        // 행 체크
        for(int i = 0; i < inputNum; i++){
            int count = 1;
            // 비교를 앞 index와 이전 index를 비교하기 위해 1부터 시작
            for(int j = 1 ; j < inputNum; j++){
                if(box[i][j].equals( box[i][j -1] ) ){
                    count++;
                    maxNum = Math.max(maxNum, count);
                } else {
                    // 사탕이 이어지지 않으므로 1 부터 다시 숫자를 샘
                    count = 1;
                } // else
            }// for
        } // for

        // 열 체크
        for(int i = 0; i < inputNum; i++){
            int count = 1;
            // 비교를 앞 index와 이전 index를 비교하기 위해 1부터 시작
            for(int j = 1 ; j < inputNum; j++) {
                if(box[j][i].equals( box[j - 1][i] )){
                    count++;
                    maxNum = Math.max(maxNum, count);
                } else {
                    // 사탕이 이어지지 않으므로 1 부터 다시 숫자를 샘
                    count = 1;
                } // else
            } // for
        } //for
    }

    public static void swap(int x1,int y1, int x2, int y2){
        String tmp = box[x1][y1];
        box[x1][y1] = box[x2][y2];
        box[x2][y2] = tmp;
    }

}
