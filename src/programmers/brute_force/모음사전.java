package programmers.brute_force;

public class 모음사전 {
    public int solution(String word) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        // 각 단어별 사용 가능한 개수
        // 5^5 + 5^4 ... + 5^0
        // 5^4 ...+ 5^0
        int[] weights = {781, 156, 31, 6, 1}; // 자릿수별 가중치

        int answer = 0;

        // 전달 받은 문자열의 문자 수 만큼 loop
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = 0;

            // 현재 문자가 vowels에서 몇 번째인지 찾음
            for (int j = 0; j < vowels.length; j++) {
                if (vowels[j] == ch) {
                    index = j;
                    break;
                } // if
            } // for

            // 전달 받은 문자의  가중치 위치에 단어의 순서인 덱스를 곱한 후 자기 자신을 더 함
            answer += weights[i] * index + 1;
        } // for

        return answer;
    }
}
