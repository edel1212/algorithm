package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 사탕게임_R3 {
    static int N;
    static String[][] box;
    static int diffMax = Integer.MIN_VALUE;
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            box = new String[N][N];
            for(int i = 0 ; i < N;i++){
                String line = br.readLine();
                for(int j = 0 ; j < line.length(); j++){
                    box[i][j] = String.valueOf(line.charAt(j));
                } // for
            } // for

            for(int i = 0; i < N; i++){
                for(int j = 0 ; j < N ; j++){
                    if( i+1 < N ){
                        swap(i,j, i+1, j);
                        count();
                        swap(i,j, i+1, j);
                    } //if

                    if( j+1 < N ){
                        swap(i,j, i, j + 1);
                        count();
                        swap(i,j, i, j + 1);
                    } //if
                }//for
            } // for

            bw.write(String.valueOf(diffMax));
        } catch (Exception e){
            e.printStackTrace();
        } // try-catch
    }

    public static void swap(int x, int y, int x2, int y2){
        String tmp = box[x][y];
        box[x][y] = box[x2][y2];
        box[x2][y2] = tmp;
    } // for


    public static void count(){
        for(int i = 0 ; i < N ; i++){
            int count = 1;
            for(int j = 1; j < N ; j++ ){
                if(box[i][j].equals(box[i][j - 1])){
                    count++;
                    diffMax = Math.max(diffMax, count);
                } else {
                    count = 1;
                } // else
            } //for
        } //for

        for(int i = 0 ; i < N ; i++){
            int count = 1;
            for(int j = 1; j < N ; j++ ){
                if(box[j][i].equals(box[j-1][i])){
                    count++;
                    diffMax = Math.max(diffMax, count);
                } else {
                    count = 1;
                } // else
            } //for
        } //for
    }
}
