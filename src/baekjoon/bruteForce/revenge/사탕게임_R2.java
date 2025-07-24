package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 사탕게임_R2 {
    static int inputNum;
    static String[][] box;
    static int maxNum = Integer.MIN_VALUE;
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

            for(int i = 0 ; i < inputNum; i++){

                for(int j = 0 ; j <inputNum ; j++){

                    if(i + 1 < inputNum){
                        swap(i,j, i+1,j);
                        check();
                        swap(i,j, i+1,j);
                    }

                    if(j + 1 < inputNum){
                        swap(i,j, i,j+1);
                        check();
                        swap(i,j, i,j+1);
                    }
                } // for

            } // for

            bw.write(String.valueOf(maxNum));

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void swap (int x, int y, int x2, int y2){
        String tmp = box[x][y];
        box[x][y] = box[x2][y2];
        box[x2][y2] = tmp;
    }


    public static void check(){
        // 열
        for(int i = 0 ; i < inputNum; i++){
            int count = 1;
            for(int j = 1 ; j < inputNum ; j++){
                if(box[i][j - 1].equals(box[i][j])){
                    count++;
                    maxNum = Math.max(maxNum, count);
                } else {
                    count = 1;
                } // if - else
            } // for
        } // for

        // 열
        for(int i = 0 ; i < inputNum; i++){
            int count = 1;
            for(int j = 1 ; j < inputNum ; j++){
                if(box[j - 1][i].equals(box[j][i])){
                    count++;
                    maxNum = Math.max(maxNum, count);
                } else {
                    count = 1;
                } // if - else
            } // for
        } // for
    }
}
