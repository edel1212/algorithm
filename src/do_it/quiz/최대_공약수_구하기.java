package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 최대_공약수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        long l1 = Long.parseLong(stringTokenizer.nextToken());
        long l2 = Long.parseLong(stringTokenizer.nextToken());

        long gcdResult = gcd(l1,l2);

        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < gcdResult; i++) {
            sb.append("1");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static long gcd(long o1, long o2){
        long tmp = o1 % o2;
        if(tmp == 0) return o2;
        return gcd(o2,tmp);
    }

}
