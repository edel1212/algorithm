package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 찍기 {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int inputCount = Integer.parseInt(br.readLine());
            String[] correctAnswers = new String[inputCount];

            String answerStr = br.readLine();

            for(int i = 0 ; i < inputCount; i ++){
                correctAnswers[i] = String.valueOf(answerStr.charAt(i));
            } // for

            String[] Adrian = {"A", "B", "C"};
            String[] Bruno = {"B", "A", "B", "C"};
            String[] Goran = {"C", "C", "A", "A", "B", "B"};

            int AdrianScore = 0;
            int BrunoScore = 0;
            int GoranScore = 0;
            int maxScore;

            for(int i = 0 ; i < correctAnswers.length; i++){
                String correctAnswer = correctAnswers[i];
                if(correctAnswer.equals( Adrian[  i % Adrian.length ] )) AdrianScore++;
                if(correctAnswer.equals( Bruno[  i % Bruno.length  ] )) BrunoScore++;
                if(correctAnswer.equals( Goran[   i  % Goran.length] )) GoranScore++;
            } // for

            maxScore = Math.max(AdrianScore, Math.max(BrunoScore, GoranScore));
            bw.write(String.valueOf(maxScore));
            bw.newLine();
            if(maxScore == AdrianScore){
                bw.write("Adrian");
                bw.newLine();
            }
            if(maxScore == BrunoScore){
                bw.write("Bruno");
                bw.newLine();
            }

            if(maxScore == GoranScore){
                bw.write("Goran");
                bw.newLine();
            }

        } catch(Exception e){
            e.printStackTrace();
        }

    }



}
