import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 단어의 개수 N 입력

        int groupWordCount = 0; // 그룹 단어의 개수 초기화

        for (int i = 0; i < N; i++) {
            String word = br.readLine(); // 단어 입력
            boolean[] visited = new boolean[26]; // 알파벳 소문자 26개를 체크할 배열

            boolean isGroupWord = true; // 그룹 단어인지 확인하는 플래그

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);

                if (!visited[c - 'a']) { // 해당 알파벳이 처음 등장한 경우
                    visited[c - 'a'] = true; // 방문 체크

                } else { // 해당 알파벳이 이미 등장한 경우
                    if (word.charAt(j - 1) != c) { // 이전 알파벳과 다르다면 그룹 단어가 아님
                        isGroupWord = false;
                        break;
                    }
                }
            }

            if (isGroupWord) {
                groupWordCount++; // 그룹 단어라면 개수 증가
            }
        }

        bw.write(String.valueOf(groupWordCount)); // 그룹 단어의 개수를 문자열로 변환하여 출력
        bw.newLine(); // 개행
        bw.flush(); // 버퍼 비우기

        br.close();
        bw.close();
    }
}

