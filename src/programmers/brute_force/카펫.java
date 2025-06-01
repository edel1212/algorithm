package programmers.brute_force;

public class 카펫 {
    public static void main(String[] args) {
        new 카펫().solution(8, 1);
    }

    // goal : 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤다.
    //        Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때
    //        카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
    // 10,	2 ==> [4, 3]

    // 제한사항
    //갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
    //노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
    //카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // 카펫의 총 개수
        int carpet = brown + yellow;

        // 카펫의 새로 개수는 무조건 3개 이상부터 시작하기에 3으로 사작
        for (int col = 3; col <= carpet; col++) {
            // 가로 ( 면적 공식 : 가로 * 세로  )
            int row = carpet / col;

            // 가로의 갯수가 3 이하 일 경우 ( 노랑색이 들어 갈 수 없음 )
            if (row < 3) continue;

            //  "가로는 세로의 길이보다 크거나 같다" 조건
            if (row >= col) {
                // yellow의 넓이를 구하는 공식은 (가로 - 2) * (세로 - 2)
                if ((row - 2) * (col - 2) == yellow) {
                    answer[0] = row;
                    answer[1] = col;
                    break;
                } // if
            } // if
        } // for

        return answer;
    }

    public int[] solution2(int brown, int yellow) {
        int total = brown + yellow;

        for (int height = 3; height <= total / height; height++) {
            // 자연수인지 확인하는 과정 - 가로 값이 소수일 경우 카펫을 만들 수 없음
            if (total % height != 0) continue;

            int width = total / height;

            int innerWidth = width - 2;
            int innerHeight = height - 2;

            // 좌우 양옆 2개씩 사용하니까 2씩 뺀다음 곱해서 노랑색 영역을 확인하는 것
            if (innerWidth * innerHeight == yellow) {
                return new int[]{width, height};
            }
        }

        return new int[0]; // 문제 조건상 항상 답이 존재함
    }
}
