package do_it.quiz.revange;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 회의실_배정_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 회의 개수
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new Meeting(s, e));
        } // for

        int meetingEndTime = 0;
        int count = 0;
        while(!pq.isEmpty()){
            Meeting current = pq.poll();
            if(current.start >= meetingEndTime){
                meetingEndTime = current.end;
                count++;
            } // if
        }// while

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            // 종료 시간이 같을 경우
            if(this.end == o.end){
                // 회의 시작 시간이 빠른 것으로 정렬 ( 시작하자마자 종료하는 회의도 있기 때문임 )
                return Integer.compare(this.start, o.start);
            } // if
            // 회의 끝나는 시간이 빠른것부터 정렬
            return Integer.compare(this.end, o.end);
        }
    }
}
