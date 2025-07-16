package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 거꾸로_구구단 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer strToken = new StringTokenizer(br.readLine()," ");

            int base  = Integer.parseInt(strToken.nextToken());
            int range = Integer.parseInt(strToken.nextToken());

            int maxNum  = Integer.MIN_VALUE;

            for(int i = 1; i <= range; i++){
                maxNum = Math.max( maxNum, convert(String.valueOf( base *i)) );
            } // for

            bw.write( String.valueOf( maxNum ) );

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int convert(String s){
        String tmp = "";
        for(int i = s.length(); 0 < i; i-- ) tmp += s.charAt(i - 1);
        return Integer.parseInt(tmp);
    }

    public static int convert2(String s){
        return Integer.parseInt(new StringBuilder(s).reverse().toString());
    }
}
