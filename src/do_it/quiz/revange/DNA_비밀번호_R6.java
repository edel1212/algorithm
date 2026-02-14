package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class DNA_비밀번호_R6 {
    // A,C,G,T
    static int[] correct = new int[4];
    // A,C,G,T
    static int[] current = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전달 받은 문자열
        int S = Integer.parseInt(st.nextToken());
        // 비밀번호 자릿수
        int P = Integer.parseInt(st.nextToken());

        // 입력 받은 문자열
        char[] A = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        // 필수 암호 개수 저장
        for(int i = 0 ; i < 4 ; i++){
            correct[i] = Integer.parseInt(st.nextToken());
        } // for

        int left = 0;
        int right = P ;

        for(int i = left ; i < right ; i++){
            add(A[i]);
        } // for

        int result = 0;
        if(isOk()) result++;

        while(right < S){
            // 문자열 제거
            remove(A[left]);
            left++;
            // 문자열 추가
            add(A[right]);
            right++;
            if(isOk()) result++;
        } // while

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static void add(char c) {
        switch (c) {
            case 'A':
                current[0]++;
                break;
            case 'C':
                current[1]++;
                break;
            case 'G':
                current[2]++;
                break;
            case 'T':
                current[3]++;
                break;
            // 문제 조건상 다른 문자가 안 들어온다면 default는 생략해도 되지만,
            // 안전을 위해 예외처리를 유지한다면 아래와 같습니다.
            default:
                throw new RuntimeException("Error");
        }
    }

    static void remove(char c) {
        switch (c) {
            case 'A':
                current[0]--;
                break;
            case 'C':
                current[1]--;
                break;
            case 'G':
                current[2]--;
                break;
            case 'T':
                current[3]--;
                break;
            default:
                throw new RuntimeException("Error");
        }
    }

    static boolean isOk(){
        for(int i = 0 ; i < 4 ; i ++){
            if(correct[i] > current[i]) return false;
        }// for
        return true;
    }

}
