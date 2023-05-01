package generalMath1;

import java.io.*;
import java.util.StringTokenizer;

public class Q2869_Succ {
    /**
     * 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
     *
     * 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
     *
     * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
     *
     * 첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)
     *
     * 첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer init = new StringTokenizer(br.readLine());

            // 낮에 올라간 높이
            int up = Integer.valueOf(init.nextToken());
            // 밤에 자면서 미끄러진 높이
            int down = Integer.valueOf(init.nextToken());
            // 목표하는 높이
            int length = Integer.valueOf(init.nextToken());

            /**
             * 👉 포인트 마지막에 도달할 때는 미끄러지지 않는 다는것
             * - 해당 조건이 없었으면 length / ( up - down ) 으로 쉽게 구현이 가능 했을것이다.
             *    ==> 사실상 down이 없는것이기 때문임
             * **/

            /**
             * 💬 풀이 포인트
             * 예시값으로 2 1 5 가 들어왔을 경우
             * 1일차 낮 = up                                       (2)
             * 1일차 밤 = up - down                                (1)
             * 2일차 낮 = up - down + up                           (3)
             * 2일차 밤 = up - down + up - down                    (2)
             * 3일차 낮 = up - down + up - down + up               (4)
             * 3일차 밤 = up - down + up - down + up - down        (3)
             * 4일차 낮 = up - down + up - down + up - down  + up  (5)
             * ...
             * n일차 낮 = (up - down)n + up
             * */

            /**
             * 어쨋든 도착하는것은 무조건 낮에 도착하므로 [ 낮에만 +가 된다. ]
             * (length - up) / (up - down) + 1 을 해주면 하루동안 올라가는 길이로
             * 며칠이 걸릴지 확인이 가능하다.
             *
             * ✅ 그치만  (length - up) % (up - down)가 딱 나눠 떨어지지 않을 경우
             *    나머지가 존재하므로 일 수가 +1이 아닌 +2를 해줘야 한다!!!
             * */

            // 목표 길이에서 올라갈 값을 뺸 후 나누면 나머지 몫을 무시한 기본 카운트 날짜를 구할 수 있다.
            int dayCnt = (length - up) / (up - down);

            // 나머지 올라갈 거리를 확인하여 없다면 하루를 주고 있다면 2를 준다.
            if((length - up) % (up - down) == 0){
                dayCnt += 1;
            } else {
                dayCnt += 2;
            }

            bw.write(String.valueOf(dayCnt));
            bw.flush();
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
