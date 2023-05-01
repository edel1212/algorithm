package generalMath1;

import java.io.*;
import java.util.StringTokenizer;

public class Q2869_Retry {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer init = new StringTokenizer(br.readLine());

            // 낮에 올라간 높이
            int up = Integer.valueOf(init.nextToken());
            // 밤에 자면서 미끄러진 높이
            int down = Integer.valueOf(init.nextToken());
            // 목표하는 높이
            int goal = Integer.valueOf(init.nextToken());

            int day = (goal - up) / (up - down);

            if((goal - up) % (up - down) == 0){
                day += 1;
            } else { // 나머지가 있을 경우
                day += 2;
            }
            bw.write(String.valueOf(day));
            bw.flush();
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
