package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 사탕게임_R4 {
    static int diffMax = Integer.MIN_VALUE;
    static String[][] box;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int N = Integer.parseInt(br.readLine());
            box = new String[N][N];
            for(int i = 0 ; i < N ; i++){
                String line = br.readLine();
                for(int j = 0 ; j < N ; j++){
                    box[i][j] = String.valueOf(line.charAt(j));
                } //for
            } // for


            for(int i = 0 ; i < N ;i ++){
                for(int j = 0 ; j < N ; j++){
                    if( i + 1 < N){
                        swap(i,j, i+ 1, j);
                        count(N);
                        swap(i,j, i+ 1, j);
                    } // if

                    if( j + 1 < N){
                        swap(i,j, i, j + 1);
                        count(N);
                        swap(i,j, i, j + 1);
                    } // if
                } // for
            } // for

            bw.write(String.valueOf(diffMax));
        } catch (Exception e){
          e.printStackTrace();
        }  //try - catch
    }

    public static void swap(int x , int y, int x1, int y1){
        String tmp = box[x][y];
        box[x][y] = box[x1][y1];
        box[x1][y1] = tmp;
    }

    public static void count(int N){
        // 박스 Loop - 열 비교
        for(int i = 0; i < N ; i++){
            int count = 1;
            // 1부터 시작 이유는 -1을 통해 이전 것을 비교하기 위함
            for(int j = 1 ; j < N ; j++){
                if(box[i][j].equals(box[i][j-1])){
                    count++;
                } else {
                    count = 1;
                } // if - else
                diffMax = Math.max(diffMax, count);
            } // for
        } // for

        // 박스 Loop - 행 비교
        for(int i = 0; i < N ; i++){
            int count = 1;
            // 1부터 시작 이유는 -1을 통해 이전 것을 비교하기 위함
            for(int j = 1 ; j < N ; j++){
                if(box[j][i].equals(box[j-1][i])){
                    count++;
                } else {
                    count = 1;
                } // if - else
                diffMax = Math.max(diffMax, count);
            } // for
        } // for
    }

}
